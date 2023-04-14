package com.jeremias.dev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeremias.dev.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}

