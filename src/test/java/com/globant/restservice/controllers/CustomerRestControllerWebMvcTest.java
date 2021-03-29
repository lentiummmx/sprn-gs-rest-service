package com.globant.restservice.controllers;

import com.globant.restservice.models.Customer;
import com.globant.restservice.services.ICustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)    // JUnit4
//@ExtendWith(SpringExtension.class)  // JUnit5
@WebMvcTest(CustomerController.class)
class CustomerRestControllerWebMvcTest {
//class CustomerRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ICustomerService customerService;

    private Customer chloe;

    @BeforeEach
    void setUp() {
        chloe = new Customer("Chloe", "O'Brian");
        chloe.setId(2L);

        given(customerService.findById(2L)).willReturn(chloe);

        List<Customer> allCustomers = Arrays.asList(chloe);
        given(customerService.findByLastName("O'Brian")).willReturn(allCustomers);
    }

    @Test
    void findByLastName() throws Exception {
        mvc.perform(get("/customers/byLastName/O'Brian").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(chloe.getFirstName())));
    }

    @Test
    void findById() throws Exception {
        mvc.perform(get("/customer/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(3)))
                .andExpect(jsonPath("$.firstName", is(chloe.getFirstName())))
                .andExpect(jsonPath("firstName", is(chloe.getFirstName())));
    }
}