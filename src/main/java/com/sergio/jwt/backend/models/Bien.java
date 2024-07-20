package com.sergio.jwt.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.Optional;
import com.sergio.jwt.backend.repository.PropertyPaymentRepository;

@Entity
@Table(name = "biens") // Spécifie le nom de la table dans la base de données
public class Bien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nom;

    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private String localisation;

    private Date dateAcquisition;

    private double valeur;

    @Size(max = 50)
    private String etat;

    private String image;

    @Size(max = 50)
    private String vacant; // Nouveau champ pour indiquer si le bien est vacant
    @Size(max = 50)
    private String typeContrat;
    public Bien() {
    }

    public Bien(Long id, String nom, String description, String localisation, Date dateAcquisition, double valeur, String etat, String image, String vacant, String typeContrat) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.localisation = localisation;
        this.dateAcquisition = dateAcquisition;
        this.valeur = valeur;
        this.etat = etat;
        this.image = image;
        this.vacant = vacant;
        this.typeContrat = typeContrat;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public double getValeur() {
        return valeur;
    }

    public String getEtat() {
        return etat;
    }

    public String getImage() {
        return image;
    }

    public String getVacant() {
        return vacant; // Getter pour le champ vacant
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setVacant(String vacant) {
        this.vacant = vacant; // Setter pour le champ vacant
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }




}
