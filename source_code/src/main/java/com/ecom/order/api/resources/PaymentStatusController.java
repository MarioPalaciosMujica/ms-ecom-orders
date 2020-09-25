package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.PaymentStatusMap;
import com.ecom.order.api.models.PaymentStatusModel;
import com.ecom.order.services.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/PaymentStatus")
public class PaymentStatusController {

    @Autowired private PaymentStatusService paymentStatusService;
    @Autowired private PaymentStatusMap paymentStatusMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull PaymentStatusModel model){
        paymentStatusService.save(paymentStatusMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<PaymentStatusModel> findAll(){
        return paymentStatusMap.toModelList(paymentStatusService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public PaymentStatusModel findById(@PathVariable @NotNull Long id){
        return paymentStatusMap.toModel(paymentStatusService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull PaymentStatusModel model){
        paymentStatusService.update(paymentStatusMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        paymentStatusService.deleteById(id);
    }
}
