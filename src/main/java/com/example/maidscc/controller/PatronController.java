package com.example.maidscc.controller;

import com.example.maidscc.Repository.PatronRepository;
import com.example.maidscc.entity.PatronEntity;
import com.example.maidscc.service.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class PatronController {


    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<PatronEntity> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatronEntity> getPatronById(@PathVariable Long id) {
        Optional<PatronEntity> patron = patronService.getPatronById(id);
        return patron.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PatronEntity> addPatron(@Valid @RequestBody PatronEntity patron) {
        PatronEntity newPatron = patronService.addPatron(patron);
        return ResponseEntity.status(201).body(newPatron);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronEntity> updatePatron(@PathVariable Long id, @Valid @RequestBody PatronEntity newPatron) {
        Optional<PatronEntity> updatedPatron = patronService.updatePatron(id, newPatron);
        return updatedPatron.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        if (patronService.getPatronById(id).isPresent()) {
            patronService.deletePatron(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
