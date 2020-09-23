package com.ecom.order.services;

import com.ecom.order.dalc.entities.PaymentMethod;
import com.ecom.order.dalc.repositories.IPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired private IPaymentMethodRepository paymentMethodRepository;

    public PaymentMethod save(PaymentMethod entity){
        entity.setIdPaymentMethod(null);
        return paymentMethodRepository.save(entity);
    }

    public PaymentMethod findById(Long id){
        Optional<PaymentMethod> entity = paymentMethodRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PaymentMethod> findAll(){
        return paymentMethodRepository.findAll();
    }

    public boolean update(@NotNull PaymentMethod entity){
        PaymentMethod original = this.findById(entity.getIdPaymentMethod());
        if(original != null){
            paymentMethodRepository.save(entity);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteById(Long id){
        if(this.findById(id) != null){
            paymentMethodRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
