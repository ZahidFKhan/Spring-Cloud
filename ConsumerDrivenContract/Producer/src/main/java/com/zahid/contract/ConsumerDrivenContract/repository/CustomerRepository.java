package com.zahid.contract.ConsumerDrivenContract.repository;

import com.zahid.contract.ConsumerDrivenContract.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {}
