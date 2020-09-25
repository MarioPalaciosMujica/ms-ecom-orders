package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.TaxMap;
import com.ecom.order.api.models.TaxModel;
import com.ecom.order.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/Tax")
public class TaxController {

    @Autowired private TaxService taxService;
    @Autowired private TaxMap taxMap;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody @NotNull TaxModel model){
        taxService.save(taxMap.toEntity(model));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<TaxModel> findAll(){
        return taxMap.toModelList(taxService.findAll());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public TaxModel findById(@PathVariable @NotNull Long id){
        return taxMap.toModel(taxService.findById(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void update(@RequestBody @NotNull TaxModel model){
        taxService.update(taxMap.toEntity(model));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        taxService.deleteById(id);
    }
}
