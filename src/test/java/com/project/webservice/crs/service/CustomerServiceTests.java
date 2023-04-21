package com.project.webservice.crs.service;

import com.project.webservice.crs.exception.custom.NotFoundException;
import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.repository.impl.CustomerRepoImpl;
import com.project.webservice.crs.services.CustomerService;
import com.project.webservice.crs.services.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {
    @Mock
    CustomerRepoImpl customerRepo;

    @Autowired
    CustomerService service;
@BeforeEach
void setUp()
{
    service=new CustomerServiceImpl(customerRepo);
}

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
