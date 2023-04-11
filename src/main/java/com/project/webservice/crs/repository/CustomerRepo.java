package com.project.webservice.crs.repository;

import com.project.webservice.crs.model.CustomerReg;

public interface CustomerRepo {
    CustomerReg getCustByRegNum(String ppsn);

    void DeleteCustByRegNum(String ppsn);
}
