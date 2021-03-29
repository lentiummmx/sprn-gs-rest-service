package com.globant.restservice.services.impl;

import com.globant.restservice.configs.CustomerServiceTestContextConfiguration;
import com.globant.restservice.models.Customer;
import com.globant.restservice.services.ICustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)  // JUnit4
//@ExtendWith(SpringExtension.class)  // JUnit 5
//@SpringBootTest
@Import(CustomerServiceTestContextConfiguration.class)
public class CustomerServiceIntegration2ndTest {

    @Autowired
//    @Resource(name = "customerServiceTest")
    private ICustomerService customerService;

    @Test
    public void findByLastName() {
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
    public void findById() {
    }
}