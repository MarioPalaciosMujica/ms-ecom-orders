package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.BuyOrderMap;
import com.ecom.order.api.mapping.PurchaseOrderMap;
import com.ecom.order.api.mapping.PurchaseOrderSummaryMap;
import com.ecom.order.api.mapping.ResultTransactionMessageMap;
import com.ecom.order.api.models.BuyOrderModel;
import com.ecom.order.api.models.PurchaseOrderModel;
import com.ecom.order.api.models.PurchaseOrderSummaryModel;
import com.ecom.order.api.models.ResultTransactionMessageModel;
import com.ecom.order.config.AppConfig;
import com.ecom.order.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/PurchaseOrder")
public class PurchaseOrderController {

    @Autowired private PurchaseOrderService purchaseOrderService;
    @Autowired private PurchaseOrderMap purchaseOrderMap;
    @Autowired private PurchaseOrderSummaryMap purchaseOrderSummaryMap;
    @Autowired private BuyOrderMap buyOrderMap;
    @Autowired private ResultTransactionMessageMap resultTransactionMessageMap;
    @Autowired private AppConfig appConfig;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BuyOrderModel save(@RequestBody @NotNull PurchaseOrderModel model){
        return buyOrderMap.toModel(purchaseOrderService.save(purchaseOrderMap.toEntity(model)));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<PurchaseOrderModel> findAll(){
        return purchaseOrderMap.toModelList(purchaseOrderService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public PurchaseOrderModel findById(@PathVariable @NotNull Long id){
        return purchaseOrderMap.toModel(purchaseOrderService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull PurchaseOrderModel model){
        purchaseOrderService.update(purchaseOrderMap.toEntity(model));
    }

    @RequestMapping(value = "/updatePaymentTransaction", method = RequestMethod.POST)
    public void updatePaymentTransaction(@RequestBody @NotNull ResultTransactionMessageModel model){
        System.out.println("PurchaseOrderController.updatePaymentTransaction()"); //DEBUG
        String idPurchaseOrder = purchaseOrderService.updatePaymentTransaction(resultTransactionMessageMap.toEntity(model));
    }

    @RequestMapping(value = "/findAllByStatus/{idPurchaseOrderStatus}", method = RequestMethod.GET)
    public List<PurchaseOrderModel> findAllByStatus(@PathVariable @NotNull Long idPurchaseOrderStatus){
        return purchaseOrderMap.toModelList(purchaseOrderService.findAllByStatus(idPurchaseOrderStatus));
    }

    @RequestMapping(value = "/calculateSummary", method = RequestMethod.GET)
    public PurchaseOrderSummaryModel calculateSummary(@RequestBody @NotNull PurchaseOrderModel model){
        return purchaseOrderSummaryMap.toModel(purchaseOrderService.calculateSummary(purchaseOrderMap.toEntity(model)));
    }
}
