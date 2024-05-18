package com.example.maidscc.service;


import com.example.maidscc.Repository.PatronRepository;
import com.example.maidscc.entity.PatronEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrons")
public class PatronService {


    @Autowired
    private PatronRepository patronRepository;

    public List<PatronEntity> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Optional<PatronEntity> getPatronById(Long id) {
        return patronRepository.findById(id);
    }


    @Transactional
    public PatronEntity addPatron(PatronEntity patron) {
        return patronRepository.save(patron);
    }

    @Transactional
    public Optional<PatronEntity> updatePatron(Long id, PatronEntity newPatron) {
        return patronRepository.findById(id).map(existingPatron -> {
            existingPatron.setName(newPatron.getName());
            existingPatron.setContactInformation(newPatron.getContactInformation());
            return patronRepository.save(existingPatron);
        });
    }

    @Transactional
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
