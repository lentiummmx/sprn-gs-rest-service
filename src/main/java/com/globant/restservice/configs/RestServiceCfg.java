package com.globant.restservice.configs;

import com.globant.restservice.generators.HelloCustomerGenerator;
import com.globant.restservice.generators.SingletonBean;
import com.globant.restservice.models.Customer;
import com.globant.restservice.models.Person;
import com.globant.restservice.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Configuration
//@EnableJpaRepositories(basePackages = "com.globant.restservice.repositories")
@EnableJpaRepositories("com.globant.restservice.repositories")
public class RestServiceCfg {

    private static final Logger log = LoggerFactory.getLogger(RestServiceCfg.class);

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });

            //for (Customer bauer : repository.findByLastName("Bauer")) {
            //    log.info(bauer.toString());
            //}
            log.info("");
        };
    }

    @Bean
    @Scope("singleton")
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    //@Scope("prototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person personPrototype() {
        return new Person();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@RequestScope
    public HelloCustomerGenerator requestScopedBean() {
        return new HelloCustomerGenerator();
    }

    @Bean
    //@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @SessionScope
    public HelloCustomerGenerator sessionScopedBean() {
        return new HelloCustomerGenerator();
    }

    @Bean
    //@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @ApplicationScope
    public HelloCustomerGenerator applicationScopedBean() {
        return new HelloCustomerGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloCustomerGenerator websocketScopedBean() {
        return new HelloCustomerGenerator();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonBean sSingletonBean() {
        return SingletonBean.getInstance();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SingletonBean pSingletonBean() {
        return SingletonBean.getInstance();
    }

}
