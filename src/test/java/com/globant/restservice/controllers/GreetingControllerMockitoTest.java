package com.globant.restservice.controllers;

import com.globant.restservice.models.Greeting;
import com.globant.restservice.services.impl.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingControllerMockitoTest {

    @Mock
    private GreetingService greetingService;

    @InjectMocks
    private GreetingController greetingController;

    @BeforeEach
    void setUp() {
        when(greetingService.getGreeting(1, "Hello, World!")).thenReturn(new Greeting(1, "Hello, World!"));
    }

    @Test
    void greeting() {
        Greeting response = greetingController.greeting("World");
        assertThat(response).isEqualTo(new Greeting(1, "Hello, World!"));
    }
}