package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.PaymentMethodMap;
import com.ecom.order.api.models.PaymentMethodModel;
import com.ecom.order.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/PaymentMethod")
public class PaymentMethodController {

    @Autowired private PaymentMethodService paymentMethodService;
    @Autowired private PaymentMethodMap paymentMethodMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull PaymentMethodModel model){
        paymentMethodService.save(paymentMethodMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<PaymentMethodModel> findAll(){
        return paymentMethodMap.toModelList(paymentMethodService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public PaymentMethodModel findById(@PathVariable @NotNull Long id){
        return paymentMethodMap.toModel(paymentMethodService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull PaymentMethodModel model){
        paymentMethodService.update(paymentMethodMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        paymentMethodService.deleteById(id);
    }

}
