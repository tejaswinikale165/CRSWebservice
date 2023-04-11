package com.project.webservice.crs.repository;

import com.project.webservice.crs.model.CustomerReg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRepoImpl implements CustomerRepo {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public CustomerReg getCustByRegNum(String ppsn) {
        Session session= sessionFactory.getCurrentSession();

        return session.get(CustomerReg.class,ppsn);
    }


    public void  DeleteCustByRegNum(String ppsn) {
        Session session= sessionFactory.getCurrentSession();
        CustomerReg customerReg=session.get(CustomerReg.class,ppsn);
        session.delete(customerReg);
    }
}
