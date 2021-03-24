package com.globant.restservice.services.impl;

import com.globant.restservice.configs.CustomerServiceTestCntxtConfg;
import com.globant.restservice.models.Customer;
import com.globant.restservice.repositories.CustomerRepository;
import com.globant.restservice.services.ICustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)  // JUnit4
@ExtendWith(SpringExtension.class)  // JUnit 5
//@SpringBootTest
class CustomerServiceIntegration3rdTest {

    @TestConfiguration
    static class CustomerServiceTestCntxtConfg {
        @Bean
        public ICustomerService customerServiceTest() {
            return new CustomerService();
        }
    }

    @Autowired
    @Qualifier("customerServiceTest")
//    @Resource(name = "customerServiceTest")
    private ICustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        List<Customer> testLst = new ArrayList<>();
        Customer customer = new Customer("Jack", "Bauer");
        customer.setId(1L);
        testLst.add(customer);
        //testLst.add(new Customer("Chloe", "O'Brian"));
        customer = new Customer("Kim", "Bauer");
        customer.setId(3L);
        testLst.add(customer);
        when(customerRepository.findByLastName("Bauer")).thenReturn(testLst);
    }

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

        List<Customer> customersSrvc = customerService.findByLastName("Bauer");
        assertEquals(testLst, customersSrvc);
    }

    @Test
    void findById() {
    }
}