package com.safalifter.jobservice.controller;


import com.safalifter.jobservice.model.Customer;
import com.safalifter.jobservice.model.Order;
import com.safalifter.jobservice.model.Queue;
import com.safalifter.jobservice.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queue")
@RequiredArgsConstructor

public class QueueController {

    private QueueService queueService;

    // Get queue details for a specific shop
    @GetMapping("/{shopId}")
    public Queue getQueueDetails(@PathVariable String shopId) {
        return queueService.getQueueDetails(shopId);
    }

    // Add customer to the queue
    @PostMapping("/{shopId}/add")
    public Customer addCustomerToQueue(@PathVariable String shopId, @RequestBody String customerName) {
        return queueService.addCustomerToQueue(shopId, customerName);
    }

    // Take a customer off the queue (serve them)
    @PostMapping("/service/{customerId}")
    public void serviceCustomer(@PathVariable Long customerId) {
        queueService.serviceCustomer(customerId);
    }

    // Get orders placed by a specific customer
    @GetMapping("/orders/{customerId}")
    public List<Order> getCustomerOrders(@PathVariable Long customerId) {
        return queueService.getCustomerOrders(customerId);
    }
}
