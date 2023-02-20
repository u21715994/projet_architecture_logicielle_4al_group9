package com.example.projet_architecture_logicielle_4al_groupe_9;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Consultant {
    String id;
    @JsonProperty
    String firstName;
    @JsonProperty
    String lastName;
    @JsonProperty
    Float averageDailyRate;
    @JsonProperty
    List<String> skills;
    @JsonProperty
    List<Disponibility> disponibilities;
    @JsonProperty
    PayementMode payementMode;

    public Consultant(String firstName, String lastName, Float averageDailyRate,List<String> skills,
                      List<Disponibility> disponibilities, PayementMode payementMode){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageDailyRate = averageDailyRate;
        this.skills = skills;
        this.disponibilities = disponibilities;
        this.payementMode = payementMode;
    }

    public Consultant(Consultant consultant){
        this.firstName = consultant.firstName;
        this.lastName = consultant.lastName;
        this.averageDailyRate = averageDailyRate;
        this.skills = consultant.skills;
        this.disponibilities = consultant.disponibilities;
        this.payementMode = payementMode;
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "ID='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills='" + skills + '\'' +
                ", disponibilities=" + disponibilities +
                '}';
    }
}
