package com.project.webservice.crs.repository;

import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.repository.impl.CustomerRepoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerRepoTests {

    @Autowired
    CustomerRepoImpl customerRepo;

    CustomerReg customerReg;
@BeforeEach
public void populateCustReg()
{
     customerReg=new CustomerReg();
    customerReg.setCtAcct(12);
    customerReg.setIdEmail("test@gm]ail.com");
    customerReg.setIdEntity("123test");
    customerReg.setIdInternal(2);
}
@Test
    public void getCustByRegNumTest() {

        customerRepo.saveCustByRegNum(customerReg);
        CustomerReg result=customerRepo.getCustByRegNum(customerReg.getIdEntity());
        assertThat(result).isNotNull();
        assertThat(result.getIdInternal()).isEqualTo(2);

    }

@Test
    public void  deleteCustByRegNumTest() {

    customerRepo.saveCustByRegNum(customerReg);

        customerRepo.deleteCustByRegNum(customerReg.getIdEntity());
    assertThat(customerRepo.getCustByRegNum(customerReg.getIdEntity())).isNull();
    }
@Test
    public void  saveCustByRegNumTest() {

        customerRepo.saveCustByRegNum(customerReg);
        CustomerReg result=customerRepo.getCustByRegNum(customerReg.getIdEntity());
        assertThat(result).isNotNull();
        assertThat(result.getIdInternal()).isEqualTo(2);
    }
}
