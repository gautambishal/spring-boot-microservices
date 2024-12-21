package com.safalifter.jobservice.repository;

import com.safalifter.jobservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
