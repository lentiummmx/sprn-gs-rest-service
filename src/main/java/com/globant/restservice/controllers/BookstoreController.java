package com.globant.restservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {

    @RequestMapping(method = RequestMethod.GET, value = "/recommended")
    public String readingList() {
        return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
    }

}
