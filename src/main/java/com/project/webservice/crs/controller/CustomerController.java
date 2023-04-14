package com.project.webservice.crs.controller;
import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.services.CustomerService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class CustomerController {
    //private static final Logger LOGGER= LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{ppsn}")
    public ResponseEntity<CustomerReg> getCustomer(@PathVariable String ppsn){
        //LOGGER.info("Object:"+ customerService.getCustByRegNum("18900CA").toString());
        return ResponseEntity.ok(customerService.getCustByRegNum(ppsn));
    }

    @DeleteMapping("/customer/{ppsn}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String ppsn)
    {

        customerService.deleteCustByRegNum(ppsn);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/customer")
    public  ResponseEntity<CustomerReg> createCustomer(@RequestBody CustomerReg customerReg)
    {
        CustomerReg createdCust=customerService.saveCustByRegNum(customerReg);
       return ResponseEntity.created(URI.create("/customer"+createdCust.getIdEntity())).body(createdCust);
    }
}
