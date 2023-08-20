package com.counter.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    private final NumberRepository numberRepository;

    @Autowired
    public NumberController(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @PostMapping
    public ResponseEntity<NumberEntity> updateNumberValue(@RequestBody NumberEntity updatedNumber) {
        NumberEntity existingNumber = numberRepository.findById(1L).orElse(new NumberEntity()); // Assuming the ID is 1
        existingNumber.setCounterValue(updatedNumber.getCounterValue());
        NumberEntity savedNumber = numberRepository.save(existingNumber);
        return ResponseEntity.ok(savedNumber);
    }


    @GetMapping
    public NumberEntity getNumber() {
        return numberRepository.findAll().get(0);
    }
}
