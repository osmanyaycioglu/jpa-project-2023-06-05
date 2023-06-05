package com.training.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerData {

    @Autowired
    private ICustomerDao customerDao;


    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void addCustomer(Customer customer){

    }

}
