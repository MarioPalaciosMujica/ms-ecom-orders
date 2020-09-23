package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.CouponMap;
import com.ecom.order.api.models.CouponModel;
import com.ecom.order.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Coupon")
public class CouponController {

    @Autowired private CouponService couponService;
    @Autowired private CouponMap couponMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull CouponModel model){
        couponService.save(couponMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<CouponModel> findAll(){
        return couponMap.toModelList(couponService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public CouponModel findById(@PathVariable @NotNull Long id){
        return couponMap.toModel(couponService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull CouponModel model){
        couponService.update(couponMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        couponService.deleteById(id);
    }

    @RequestMapping(value = "/findActiveByCode/{code}", method = RequestMethod.GET)
    public CouponModel findActiveByCode(@PathVariable @NotNull String code){
        return couponMap.toModel(couponService.findActiveByCode(code));
    }

}
