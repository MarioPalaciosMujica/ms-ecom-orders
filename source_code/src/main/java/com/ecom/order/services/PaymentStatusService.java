package com.ecom.order.services;

import com.ecom.order.dalc.entities.PaymentStatus;
import com.ecom.order.dalc.repositories.IPaymentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentStatusService {

    @Autowired private IPaymentStatusRepository paymentStatusRepository;

    public PaymentStatus save(PaymentStatus entity){
        entity.setIdPaymentStatus(null);
        return paymentStatusRepository.save(entity);
    }

    public PaymentStatus findById(Long id){
        Optional<PaymentStatus> entity = paymentStatusRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public List<PaymentStatus> findAll(){
        return paymentStatusRepository.findAll();
    }

    public boolean update(@NotNull PaymentStatus entity){
        PaymentStatus original = this.findById(entity.getIdPaymentStatus());
        if(original != null){
            paymentStatusRepository.save(entity);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteById(Long id){
        if(this.findById(id) != null){
            paymentStatusRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public PaymentStatus findByResponseCode(String responseCode){
        Optional<PaymentStatus> entity = paymentStatusRepository.findByResponseCode(responseCode);
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }

    public PaymentStatus findByResponseCodeAndPaymentMethod(String responseCode, String paymentMethod){
        Optional<PaymentStatus> entity = paymentStatusRepository.findByResponseCodeAndPaymentMethod(
                responseCode.trim().toUpperCase(),
                paymentMethod.trim().toUpperCase());
        if(entity.isPresent()){
            return entity.get();
        }
        else{
            return null;
        }
    }
}
