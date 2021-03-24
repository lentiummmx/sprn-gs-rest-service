package com.globant.restservice.services.impl;

import com.globant.restservice.models.Customer;
import com.globant.restservice.repositories.CustomerRepository;
import com.globant.restservice.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //@Autowired
    //public CustomerService(CustomerRepository customerRepository) {
    //    this.customerRepository = customerRepository;
    //}

    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public Customer findById(long id) {
        return customerRepository.findById(id);
    }


}
