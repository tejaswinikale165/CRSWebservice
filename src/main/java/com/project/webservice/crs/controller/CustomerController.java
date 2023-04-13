package com.project.webservice.crs.controller;
import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public CustomerReg sayHello(){
        LOGGER.info( customerService.getCustByRegNum("18900CA").toString());
        return customerService.getCustByRegNum("18900CA");
    }
}
