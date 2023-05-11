package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonkeyService {
    @Autowired protected MonkeyRepository repository;


    public Optional<Monkey> findSingle(String name) {
        return Optional.ofNullable(name)
                .flatMap(n -> repository.findAll().stream()
                        .filter(m -> m.name().equals(name))
                        .findFirst());
    }

    public List<Monkey> findAll() {
        return repository.findAll();
    }

    public UUID create(String name) {
        if (name == null) {
            return null;
        }
        return repository.create(name);
    }

    public boolean delete(String name) {
        if (name != null) {
            var m = findSingle(name);
            if (m.isPresent()) {
                return repository.deleteById(m.get().id());
            }
        }
        return false;
    }
}
