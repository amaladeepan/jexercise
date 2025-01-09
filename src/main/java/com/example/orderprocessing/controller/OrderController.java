
package com.example.orderprocessing.controller;

import com.example.orderprocessing.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private static final String TOPIC = "order-by";

    public OrderController(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        System.out.println("===================place order testing" + order.toString());
        kafkaTemplate.send(TOPIC, order);
        return "Order received: " + order.getOrderId();
    }
}
