package com.kannaan.admin.repository;

import com.kannaan.admin.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
