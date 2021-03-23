package com.globant.restservice.repositories;

import com.globant.restservice.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

//    Customer findById(long id);
    Optional<Customer> findById(long id);

}
