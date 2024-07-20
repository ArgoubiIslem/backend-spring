package com.sergio.jwt.backend.controllers;



import com.sergio.jwt.backend.models.Bien;
import com.sergio.jwt.backend.models.PropertyPayment;
import com.sergio.jwt.backend.security.services.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biens")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class BienController {

    @Autowired
    private BienService bienService;

    @GetMapping
    public List<Bien> getAllBiens() {
        return bienService.getAllBiens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bien> getBienById(@PathVariable("id") Long id) {
        return bienService.getBienById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bien> createBien(@RequestBody Bien bien) {
        Bien createdBien = bienService.saveOrUpdateBien(bien);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bien> updateBien(@PathVariable("id") Long id, @RequestBody Bien bien) {
        if (!bienService.getBienById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bien.setId(id);
        Bien updatedBien = bienService.saveOrUpdateBien(bien);
        return ResponseEntity.ok(updatedBien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBien(@PathVariable("id") Long id) {
        if (!bienService.getBienById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bienService.deleteBien(id);
        return ResponseEntity.noContent().build();
    }



}