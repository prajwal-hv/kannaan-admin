package com.kannaan.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kannaan.admin.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

    
}