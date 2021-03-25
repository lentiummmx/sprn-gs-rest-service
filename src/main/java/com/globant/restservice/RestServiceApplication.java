package com.globant.restservice;

import com.globant.restservice.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class RestServiceApplication {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RestServiceApplication.class, args);
        //testScopedBeans(applicationContext);
        //((AbstractApplicationContext) applicationContext).close();
    }

    private static void testScopedBeans(ApplicationContext applicationContext) {

        Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

        personSingletonA.setName(NAME);
        System.out.println("personSingletonA :: " + personSingletonA);
        System.out.println("personSingletonB :: " + personSingletonB);
        System.out.println("NAME.equals(personSingletonB) :: " + NAME.equals(personSingletonB.getName()));

        Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
        Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        System.out.println("personPrototypeA :: " + personPrototypeA);
        System.out.println("personPrototypeB :: " + personPrototypeB);
        System.out.println("NAME.equals(personPrototypeA) :: " + NAME.equals(personPrototypeA.getName()));
        System.out.println("NAME_OTHER.equals(personPrototypeB) :: " + NAME_OTHER.equals(personPrototypeB.getName()));

    }

}
