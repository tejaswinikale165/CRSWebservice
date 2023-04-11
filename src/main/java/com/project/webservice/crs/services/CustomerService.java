package com.project.webservice.crs.services;

import com.project.webservice.crs.model.CustomerReg;

public interface CustomerService {

    public CustomerReg getCustByRegNum(String ppsn);
}
