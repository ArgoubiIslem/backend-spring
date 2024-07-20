package com.sergio.jwt.backend.security.services;

import com.sergio.jwt.backend.models.Bien;
import com.sergio.jwt.backend.models.PropertyPayment;
import com.sergio.jwt.backend.repository.BienRepository;
import com.sergio.jwt.backend.repository.PropertyPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    @Autowired
    private PropertyPaymentRepository propertyPaymentRepository;

    // Récupère tous les biens
    public List<Bien> getAllBiens() {
        return bienRepository.findAll();
    }

    // Récupère un bien par son ID
    public Optional<Bien> getBienById(Long id) {
        return bienRepository.findById(id);
    }

    // Sauvegarde ou met à jour un bien avec gestion des transactions
    @Transactional
    public Bien saveOrUpdateBien(Bien bien) {
        return bienRepository.save(bien);
    }

    // Supprime un bien par son ID
    @Transactional
    public void deleteBien(Long id) {
        if(bienRepository.existsById(id)) {
            bienRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Bien with id " + id + " does not exist");
        }
    }
}
