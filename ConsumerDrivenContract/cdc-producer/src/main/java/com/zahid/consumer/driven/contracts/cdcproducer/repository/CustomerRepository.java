package com.zahid.consumer.driven.contracts.cdcproducer.repository;

import com.zahid.consumer.driven.contracts.cdcproducer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {}
