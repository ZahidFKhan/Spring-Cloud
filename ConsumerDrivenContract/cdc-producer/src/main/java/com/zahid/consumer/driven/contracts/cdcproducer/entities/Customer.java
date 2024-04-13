package com.zahid.consumer.driven.contracts.cdcproducer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public record Customer(@Id int id, String name) {}
