package com.globant.restservice.controllers;

import com.globant.restservice.models.Customer;
import com.globant.restservice.services.ICustomerService;
import com.globant.restservice.services.impl.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/byLastName/{lastName}")
    public List<Customer> findByLastName(@PathVariable("lastName") String lastName) {
        List<Customer> customers = customerService.findByLastName(lastName);
        customers.stream().forEach(c -> log.info(c.toString()));
        return customers;
    }

    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id.longValue());
        log.info(customer.toString());
        return customer;
    }

}
