package com.example.demo;

import java.util.UUID;

public record Monkey(UUID id, String name) {
    public Monkey(String name) {
        this(UUID.randomUUID(), name);
    }
}
