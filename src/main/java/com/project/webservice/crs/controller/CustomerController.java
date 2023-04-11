package com.project.webservice.crs.controller;
import com.project.webservice.crs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public String sayHello(){
        customerService.getCustByRegNum("18900CA");
        return "Hello TJ";
    }
}
