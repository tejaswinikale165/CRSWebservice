package com.project.webservice.crs.services.impl;

import com.project.webservice.crs.model.CustomerReg;
import com.project.webservice.crs.repository.CustomerRepo;
import com.project.webservice.crs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo custRepo;

    @Override
    public CustomerReg getCustByRegNum(String ppsn) {

        return custRepo.getCustByRegNum(ppsn);
    }

    @Override
    public void deleteCustByRegNum(String ppsn) {
        custRepo.deleteCustByRegNum(ppsn);
    }

    @Override
    public void saveCustByRegNum(CustomerReg customerReg) {
        custRepo.saveCustByRegNum(customerReg);
    }
}
