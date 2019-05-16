package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Balance REST controller
 *
 * @author abbas
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public void createOrder(@RequestBody ExchangeOrder order) {
        orderRepository.save(order);
    }

    @GetMapping
    public ExchangeOrder getOrderByOrderId(@RequestParam Long orderId) {
        return orderRepository.findByOrderId(orderId);
    }

}
