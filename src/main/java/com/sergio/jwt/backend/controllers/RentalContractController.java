package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.models.RentalContract;
import com.sergio.jwt.backend.security.services.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rental-contracts")
public class RentalContractController {

    @Autowired
    private RentalContractService rentalContractService;

    @GetMapping
    public List<RentalContract> getAllContracts() {
        return rentalContractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Optional<RentalContract> getContractById(@PathVariable Long id) {
        return rentalContractService.getContractById(id);
    }

    @PostMapping
    public RentalContract saveOrUpdateContract(@RequestBody RentalContract contract) {
        return rentalContractService.saveOrUpdateContract(contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        rentalContractService.deleteContract(id);
    }
}
