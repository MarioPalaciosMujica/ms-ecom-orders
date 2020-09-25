package com.ecom.order.api.resources;

import com.ecom.order.services.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Mock")
public class MockController {

    @Autowired private MockService mockService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public void start(){
        mockService.start();
    }

}
