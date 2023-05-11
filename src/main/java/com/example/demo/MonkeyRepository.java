package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MonkeyRepository {

    List<Monkey> findAll();
    Optional<Monkey> findById(UUID id);
    UUID create(String name);
    boolean deleteById(UUID id);
}
