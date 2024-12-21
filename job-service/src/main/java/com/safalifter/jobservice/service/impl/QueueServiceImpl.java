package com.safalifter.jobservice.service.impl;
import com.safalifter.jobservice.model.*;
import com.safalifter.jobservice.repository.*;
import com.safalifter.jobservice.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueueServiceImpl implements QueueService {

    private final QueueRepository queueRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    // Get queue details and number of waiting customers
    public Queue getQueueDetails(String shopId) {
        return this.queueRepository.findByShopId(shopId);
    }

    // Add a customer to the queue
    @Transactional
    public Customer addCustomerToQueue(String shopId, String customerName) {
        Queue queue = this.queueRepository.findByShopId(shopId);
        Customer customer = Customer.builder()
                .name(customerName)
                .queue(queue)
                .servedCount(0)
                .build();
        this.customerRepository.save(customer);
        return customer;
    }

    // Take a customer off the queue and serve them
    public void serviceCustomer(Long customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setServedCount(customer.getServedCount() + 1);  // Increment served count
            this.customerRepository.save(customer);

            Queue queue = customer.getQueue();
            queue.setQueueSize(queue.getQueueSize() - 1);  // Decrease queue size
            queue.setServedCount(queue.getServedCount() + 1);  // Increment served count
            this.queueRepository.save(queue);

            // Optionally delete the customer from the queue (service complete)
            this.customerRepository.delete(customer);
        }
    }

    // View orders placed by customers
    public List<Order> getCustomerOrders(Long customerId) {
        return this.orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Queue getQueueById(Long id) {
        return this.queueRepository.findById(id).get();
    }
}

