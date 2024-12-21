package com.safalifter.jobservice.service;

import com.safalifter.jobservice.model.Customer;
import com.safalifter.jobservice.model.Order;
import com.safalifter.jobservice.model.Queue;

import java.util.List;

public interface QueueService {
    Queue getQueueDetails(String shopId);
    Customer addCustomerToQueue(String shopId, String customerName);
    void serviceCustomer(Long customerId);
    List<Order> getCustomerOrders(Long customerId);

    Queue getQueueById(Long id);
}
