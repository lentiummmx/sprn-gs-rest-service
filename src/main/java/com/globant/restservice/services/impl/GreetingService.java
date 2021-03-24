package com.globant.restservice.services.impl;

import com.globant.restservice.models.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreeting(long id, String greeting) {
        return new Greeting(id, greeting);
    }
}
