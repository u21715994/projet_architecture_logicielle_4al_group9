package com.example.projet_architecture_logicielle_4al_groupe_9.domain;

import java.util.List;
import java.util.UUID;

public final class Consultant {
    private String id;
    private String firstName;
    private String lastName;
    private Float averageDailyRate;
    private List<String> skills;
    private List<Disponibility> disponibilities;
    private PayementMode paymentMode; // Typo fix

    public Consultant(String firstName, String lastName, Float averageDailyRate, List<String> skills,
                      List<Disponibility> disponibilities, PayementMode paymentMode){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageDailyRate = averageDailyRate;
        this.skills = skills;
        this.disponibilities = disponibilities;
        this.paymentMode = paymentMode; // Typo fix
    }

    public Consultant(Consultant consultant){
        this.firstName = consultant.firstName;
        this.lastName = consultant.lastName;
        this.averageDailyRate = consultant.averageDailyRate;
        this.skills = consultant.skills;
        this.disponibilities = consultant.disponibilities;
        this.paymentMode = consultant.paymentMode; // Typo fix
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() { // Convention de nommage pour l'ID
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public List<String> getSkills() { // Ajout d'un getter pour les compétences
        return skills;
    }

    public List<Disponibility> getDisponibilities() { // Ajout d'un getter pour les disponibilités
        return disponibilities;
    }

    public Float getAverageDailyRate() { // Ajout d'un getter pour le taux journalier moyen
        return averageDailyRate;
    }

    public PayementMode getPaymentMode() { // Ajout d'un getter pour le mode de paiement
        return paymentMode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAverageDailyRate(Float averageDailyRate) {
        this.averageDailyRate = averageDailyRate;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setDisponibilities(List<Disponibility> disponibilities) {
        this.disponibilities = disponibilities;
    }

    public void setPaymentMode(PayementMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", averageDailyRate=" + averageDailyRate +
                ", skills=" + skills +
                ", disponibilities=" + disponibilities +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
