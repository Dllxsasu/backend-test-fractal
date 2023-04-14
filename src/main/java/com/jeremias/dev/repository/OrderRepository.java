package com.jeremias.dev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeremias.dev.models.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
