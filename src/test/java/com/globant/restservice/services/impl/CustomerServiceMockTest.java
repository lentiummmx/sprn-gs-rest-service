package com.globant.restservice.services.impl;

import com.globant.restservice.models.Customer;
import com.globant.restservice.repositories.CustomerRepository;
import com.globant.restservice.services.ICustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceMockTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks    // auto inject customerRepository
    //private ICustomerService customerService =  new CustomerService(customerRepository);
    private ICustomerService customerService =  new CustomerService();

    @BeforeEach
    void setUp() {
        Customer customer = new Customer("David", "Palmer");
        customer.setId(4L);
        when(customerRepository.findById(4L)).thenReturn(customer);
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findById() {
        Customer customer = new Customer("David", "Palmer");
        customer.setId(4L);
        assertEquals(customer, customerService.findById(4L));
    }
}