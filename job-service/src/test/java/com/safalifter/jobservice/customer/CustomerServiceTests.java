package com.safalifter.jobservice.customer;

package com.safalifter.jobservice.service;

import com.safalifter.jobservice.model.Customer;
import com.safalifter.jobservice.model.Queue;
import com.safalifter.jobservice.repository.CustomerRepository;
import com.safalifter.jobservice.service.QueueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CustomerServiceTests {

    @InjectMocks
    private QueueService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customer = Customer.builder()
                .name("John Doe")
                .queue(Queue.builder().build())
                .servedCount(3)
                .build();
    }

    @Test
    void shouldAddCustomerToQueue() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer addedCustomer = customerService.addCustomerToQueue(UUID.randomUUID().toString(),"Ram");

        assertThat(addedCustomer).isNotNull();
        assertThat(addedCustomer.getName()).isEqualTo("John Doe");
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void shouldRemoveCustomerFromQueue() {
        doNothing().when(customerRepository).deleteById(anyLong());

        customerService.serviceCustomer(1L);

        verify(customerRepository, times(1)).deleteById(1L);
    }
}

