package com.training.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ICustomerDao extends JpaRepository<Customer,Long> {
}
