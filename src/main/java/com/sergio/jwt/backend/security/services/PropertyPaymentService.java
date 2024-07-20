package com.sergio.jwt.backend.security.services;



import com.sergio.jwt.backend.models.PropertyPayment;
import com.sergio.jwt.backend.repository.PropertyPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyPaymentService {

    @Autowired
    private PropertyPaymentRepository propertyPaymentRepository;

    public List<PropertyPayment> getAllPropertyPayments() {
        return propertyPaymentRepository.findAll();
    }

    public Optional<PropertyPayment> getPropertyPaymentById(Long id) {
        return propertyPaymentRepository.findById(id);
    }

    public PropertyPayment saveOrUpdatePropertyPayment(PropertyPayment propertyPayment) {
        return propertyPaymentRepository.save(propertyPayment);
    }

    public void deletePropertyPayment(Long id) {
        propertyPaymentRepository.deleteById(id);
    }
}
