package com.project.webservice.crs;

import com.project.webservice.crs.exception.custom.NotFoundException;
import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.repository.impl.CustomerRepoImpl;
import com.project.webservice.crs.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerServiceTests {
    @MockBean
    CustomerRepoImpl customerRepo;

    @Autowired
    CustomerService service;


@Test
    public void getCustByRegNumTest() {
        String ppsn="12334AA";
        CustomerReg customerReg=new CustomerReg();
        customerReg.setIdEntity(ppsn);
        when(customerRepo.getCustByRegNum(ppsn)).thenReturn(customerReg);
        CustomerReg result=service.getCustByRegNum(ppsn);
        assertThat(result).isNotNull();
        assertEquals(customerReg,result);
        verify(customerRepo,times(1)).getCustByRegNum(ppsn);
    }
    @Test
    public void getCustByRegNumNotFoundTest() {
        String ppsn="12334AA";
        CustomerReg customerReg=new CustomerReg();
        customerReg.setIdEntity(ppsn);
        when(customerRepo.getCustByRegNum(ppsn)).thenReturn(null);

        assertThrows(NotFoundException.class,()->{
            service.getCustByRegNum(ppsn);
    });

       verify(customerRepo,times(1)).getCustByRegNum(ppsn);
    }
    @Test
    public void deleteCustByRegNumTest() {
        String ppsn="12334AA";
        service.deleteCustByRegNum(ppsn);

        verify(customerRepo,times(1)).deleteCustByRegNum(ppsn);
    }

    @Test
    public void saveCustByRegNumTest() {
        String ppsn="12334AA";
        CustomerReg customerReg=new CustomerReg();
        customerReg.setIdEntity(ppsn);
       when(customerRepo.saveCustByRegNum(customerReg)).thenReturn(customerReg);
       CustomerReg result=service.saveCustByRegNum(customerReg);
       verify(customerRepo,times(1)).saveCustByRegNum(customerReg);
    }



}
