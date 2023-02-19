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
    List<String> skills;
    @JsonProperty
    List<Disponibility> disponibilities;

    public Consultant(String firstName, String lastName, List<String> skills, List<Disponibility> disponibilities){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.disponibilities = disponibilities;
    }

    public Consultant(Consultant consultant){
        this.id = consultant.id;
        this.firstName = consultant.firstName;
        this.lastName = consultant.lastName;
        this.skills = consultant.skills;
        this.disponibilities = consultant.disponibilities;
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
