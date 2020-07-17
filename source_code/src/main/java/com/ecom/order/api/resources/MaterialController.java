package com.ecom.order.api.resources;

import com.ecom.order.api.mapping.MaterialMap;
import com.ecom.order.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/Material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;
    @Autowired private MaterialMap materialMap;

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable @NotNull Long id){
        materialService.deleteById(id);
    }

}
