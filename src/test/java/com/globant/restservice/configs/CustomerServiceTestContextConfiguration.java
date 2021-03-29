package com.globant.restservice.configs;

import com.globant.restservice.models.Customer;
import com.globant.restservice.services.ICustomerService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@TestConfiguration
public class CustomerServiceTestContextConfiguration {
    @Bean
    public ICustomerService customerServiceTest() {
//    public ICustomerService customerService() {
        return new ICustomerService() {
            @Override
            public List<Customer> findByLastName(String lastName) {
                List<Customer> testLst = new ArrayList<>();
                Customer customer = new Customer("Jack", "Bauer");
                customer.setId(1L);
                testLst.add(customer);
                //testLst.add(new Customer("Chloe", "O'Brian"));
                customer = new Customer("Kim", "Bauer");
                customer.setId(3L);
                testLst.add(customer);
                return testLst;
            }

            @Override
            public Customer findById(long id) {
                return null;
            }
        };
    }
}
