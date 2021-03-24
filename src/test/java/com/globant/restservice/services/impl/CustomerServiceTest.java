package com.globant.restservice.services.impl;

import com.globant.restservice.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    void findByLastName() {
        List<Customer> testLst = new ArrayList<>();
        Customer customer = new Customer("Jack", "Bauer");
        customer.setId(1L);
        testLst.add(customer);
        //testLst.add(new Customer("Chloe", "O'Brian"));
        customer = new Customer("Kim", "Bauer");
        customer.setId(3L);
        testLst.add(customer);
        assertEquals(testLst, customerService.findByLastName("Bauer"));
    }

    @Test
    void findById() {
    }
}