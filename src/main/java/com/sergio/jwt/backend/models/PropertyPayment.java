package com.sergio.jwt.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "property_payments") // Spécifie le nom de la table dans la base de données
public class PropertyPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bien property; // Relation avec l'entité Bien

    @Min(value = 0, message = "Le montant de location doit être positif")
    private double rentalAmount;

    @Min(value = 0, message = "Le montant payé doit être positif")
    private double paidAmount;

    @NotBlank(message = "Le mode de paiement ne peut pas être vide")
    private String paymentMethod;

    public PropertyPayment() {
    }

    public PropertyPayment(Bien property, double rentalAmount, double paidAmount, String paymentMethod) {
        this.property = property;
        this.rentalAmount = rentalAmount;
        this.paidAmount = paidAmount;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bien getProperty() {
        return property;
    }

    public void setProperty(Bien property) {
        this.property = property;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}