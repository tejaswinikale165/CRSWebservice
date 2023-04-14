package com.project.webservice.crs.repository;

import com.project.webservice.crs.model.CustomerReg;

public interface CustomerRepo {
    public CustomerReg getCustByRegNum(String ppsn);

   public  void deleteCustByRegNum(String ppsn);
    public CustomerReg  saveCustByRegNum(CustomerReg customerReg);
}
