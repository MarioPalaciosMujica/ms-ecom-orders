package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.PurchaseOrderStatusMap;
import com.ecom.order.api.models.PurchaseOrderStatusModel;
import com.ecom.order.services.PurchaseOrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/PurchaseOrderStatus")
public class PurchaseOrderStatusController {

    @Autowired
    private PurchaseOrderStatusService purchaseOrderStatusService;
    @Autowired private PurchaseOrderStatusMap purchaseOrderStatusMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull PurchaseOrderStatusModel model){
        purchaseOrderStatusService.save(purchaseOrderStatusMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<PurchaseOrderStatusModel> findAll(){
        return purchaseOrderStatusMap.toModelList(purchaseOrderStatusService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public PurchaseOrderStatusModel findById(@PathVariable @NotNull Long id){
        return purchaseOrderStatusMap.toModel(purchaseOrderStatusService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull PurchaseOrderStatusModel model){
        purchaseOrderStatusService.update(purchaseOrderStatusMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        purchaseOrderStatusService.deleteById(id);
    }

}
