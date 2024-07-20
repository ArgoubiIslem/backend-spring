package com.sergio.jwt.backend.repository;

import com.sergio.jwt.backend.models.PropertyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyPaymentRepository extends JpaRepository<PropertyPayment, Long> {

}