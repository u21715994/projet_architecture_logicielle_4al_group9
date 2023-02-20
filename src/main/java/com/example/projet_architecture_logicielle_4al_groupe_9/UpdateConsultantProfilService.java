package com.example.projet_architecture_logicielle_4al_groupe_9;

import java.util.List;

public class UpdateConsultantProfilService {
    public static Consultant updateConsultantProfil(String firstName, String lastName, Float averageDailyRate, List<String> skills, List<Disponibility> disponibilities){
        return new Consultant(firstName, lastName, averageDailyRate, skills, disponibilities);
    }
}
