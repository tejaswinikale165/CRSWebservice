package com.project.webservice.crs.services.impl;

import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.repository.CustomerRepo;
import com.project.webservice.crs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo custRepo;

   
    @Override
        public CustomerReg getCustByRegNum(String ppsn) {

        return custRepo.getCustByRegNum(ppsn);
    }

    @Override
    @Transactional
    public void deleteCustByRegNum(String ppsn) {
        custRepo.deleteCustByRegNum(ppsn);
    }

    @Override
    @Transactional
    public CustomerReg saveCustByRegNum(CustomerReg customerReg) {
        return custRepo.saveCustByRegNum(customerReg);
    }
}
