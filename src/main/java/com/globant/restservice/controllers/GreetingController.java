package com.globant.restservice.controllers;

import com.globant.restservice.models.Greeting;
import com.globant.restservice.services.impl.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    // @RequestMapping(method=GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.getGreeting(counter.incrementAndGet(), String.format(template, name));
    }

}
