package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMonkeyRepo implements MonkeyRepository {

    protected List<Monkey> monkeys = new ArrayList<>();

    public InMemoryMonkeyRepo() {
        monkeys.add(new Monkey("Gorilla"));
        monkeys.add(new Monkey("Schimpanse"));
        monkeys.add(new Monkey("Orangutan"));
    }

    @Override
    public List<Monkey> findAll() {
        return monkeys;
    }

    @Override
    public Optional<Monkey> findById(UUID id) {
        return monkeys.stream().filter(m -> m.id().equals(id)).findFirst();
    }

    @Override
    public UUID create(String name) {
        Monkey m = new Monkey(name);
        while (findById(m.id()).isPresent()) {
            m = new Monkey(name);
        }
        monkeys.add(m);
        return m.id();
    }

    @Override
    public boolean deleteById(UUID id) {
        return monkeys.removeIf(m -> m.id().equals(id));
    }
}
