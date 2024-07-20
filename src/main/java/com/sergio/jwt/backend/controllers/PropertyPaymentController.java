package com.sergio.jwt.backend.controllers;



import com.sergio.jwt.backend.models.PropertyPayment;
import com.sergio.jwt.backend.security.services.PropertyPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-payments")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class PropertyPaymentController {

    @Autowired
    private PropertyPaymentService propertyPaymentService;

    @GetMapping
    public List<PropertyPayment> getAllPropertyPayments() {
        return propertyPaymentService.getAllPropertyPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyPayment> getPropertyPaymentById(@PathVariable("id") Long id) {
        return propertyPaymentService.getPropertyPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PropertyPayment> createPropertyPayment(@RequestBody PropertyPayment propertyPayment) {
        PropertyPayment createdPropertyPayment = propertyPaymentService.saveOrUpdatePropertyPayment(propertyPayment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPropertyPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyPayment> updatePropertyPayment(@PathVariable("id") Long id, @RequestBody PropertyPayment propertyPayment) {
        if (!propertyPaymentService.getPropertyPaymentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        propertyPayment.setId(id);
        PropertyPayment updatedPropertyPayment = propertyPaymentService.saveOrUpdatePropertyPayment(propertyPayment);
        return ResponseEntity.ok(updatedPropertyPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropertyPayment(@PathVariable("id") Long id) {
        if (!propertyPaymentService.getPropertyPaymentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        propertyPaymentService.deletePropertyPayment(id);
        return ResponseEntity.noContent().build();
    }
}

