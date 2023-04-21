package com.project.webservice.crs.controller;


import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.services.CustomerService;

import com.project.webservice.crs.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerControllerTests {

    @MockBean
    CustomerServiceImpl service;

    @Autowired
    MockMvc mockMvc;



    @Test
    public void getCustomerTest() throws Exception {

        String ppsn="123testA";
        CustomerReg customerReg=new CustomerReg();
        customerReg.setIdEntity(ppsn);
        when(service.getCustByRegNum(ppsn)).thenReturn(customerReg);

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/" + ppsn))
                .andExpect(MockMvcResultMatchers.status().isOk());


        //mockMvc.perform(get("/customer/123testA").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

}
