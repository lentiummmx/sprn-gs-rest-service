package com.globant.restservice.controllers;

import com.globant.restservice.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        url = String.format("http://localhost:%d", port);
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findById() throws URISyntaxException {
        Customer customer = new Customer("David", "Palmer");
        customer.setId(4L);
        ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(new URI(url + "/customer/" + 4), Customer.class);
        assertEquals(customer, responseEntity.getBody());
    }
}