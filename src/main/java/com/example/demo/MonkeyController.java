package com.example.demo;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("monkey")
public class MonkeyController {

    @Autowired MonkeyService svc;

    @GetMapping("/{name}")
    public Monkey getByName(
            @PathVariable String name
    ) {
        return svc.findSingle(name).orElse(null);
    }

    @GetMapping
    public List<Monkey> getAll() {
        return svc.findAll();
    }

    @PutMapping
    public UUID create(
        @RequestParam String name
    ) {
        return svc.create(name);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam String name
    ) {
        if (svc.delete(name)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
