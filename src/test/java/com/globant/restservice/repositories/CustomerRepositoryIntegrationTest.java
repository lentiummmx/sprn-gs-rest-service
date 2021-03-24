package com.globant.restservice.repositories;

import com.globant.restservice.models.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)    // JUnit4
@ExtendWith(SpringExtension.class)  // JUnit 5
@DataJpaTest
class CustomerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findByLastName() {
        // given
        Customer savedCustomer =  new Customer("Qwerty", "Asdfgh");
        entityManager.persist(savedCustomer);
        entityManager.flush();

        // when
        List<Customer> custLst = customerRepository.findByLastName("Asdfgh");

        // then
        for (Customer c : custLst) {
            assertThat(c.getFirstName()).isEqualTo(savedCustomer.getFirstName());
        }
    }

    @Test
    void findById() {
    }
}