package com.example.projet_architecture_logicielle_4al_groupe_9;

import java.util.ArrayList;
import java.util.List;

public class CreateConsultantProfilService {
    public static Consultant createConsultantProfil(String firstName, String lastName, List<String> skills, List<Disponibility> disponibilities){
        return new Consultant(firstName, lastName, skills, disponibilities);
    }
}
