
package com.example.orderprocessing.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.orderprocessing.repository.OrderRepository;
import com.example.orderprocessing.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderProcessor {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderProcessor(OrderRepository orderRepository, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "order-by", groupId = "order-group")
    public void processOrder(String message) {
        try {
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println("Processing order: " + order.getOrderId());
            orderRepository.save(order);
        } catch (Exception e) {
            System.err.println("Error processing order: " + e.getMessage());
        }
    }
}
