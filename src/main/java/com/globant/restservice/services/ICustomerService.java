package com.globant.restservice.services;

import com.globant.restservice.models.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
