package com.globant.restservice.models;

import lombok.Data;

@Data
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
