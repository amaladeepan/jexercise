
package com.example.orderprocessing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.orderprocessing.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}
