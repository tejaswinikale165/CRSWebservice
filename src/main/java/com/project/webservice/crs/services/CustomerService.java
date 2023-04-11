package com.project.webservice.crs.services;

import com.project.webservice.crs.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo custRepo;
}
