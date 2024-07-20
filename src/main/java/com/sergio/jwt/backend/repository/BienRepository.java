package com.sergio.jwt.backend.repository;

import com.sergio.jwt.backend.models.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {


}
