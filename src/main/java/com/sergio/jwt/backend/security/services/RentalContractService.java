package com.sergio.jwt.backend.security.services;

import com.sergio.jwt.backend.models.RentalContract;
import com.sergio.jwt.backend.repository.RentalContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalContractService {

    @Autowired
    private RentalContractRepository rentalContractRepository;

    public List<RentalContract> getAllContracts() {
        return rentalContractRepository.findAll();
    }

    public Optional<RentalContract> getContractById(Long id) {
        return rentalContractRepository.findById(id);
    }

    public RentalContract saveOrUpdateContract(RentalContract contract) {
        // Vérifiez si le contrat existe déjà
        if (contract.getId() != null && rentalContractRepository.existsById(contract.getId())) {
            // Le contrat existe, donc on le met à jour
            return rentalContractRepository.save(contract);
        } else {
            // Le contrat n'existe pas, donc on en crée un nouveau
            return rentalContractRepository.save(contract);
        }
    }

    public void deleteContract(Long id) {
        rentalContractRepository.deleteById(id);
    }
}
