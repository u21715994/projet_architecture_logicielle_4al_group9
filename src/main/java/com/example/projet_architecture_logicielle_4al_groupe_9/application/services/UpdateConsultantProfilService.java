package com.example.projet_architecture_logicielle_4al_groupe_9.application.services;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Disponibility;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PayementMode;

import java.util.List;

public class UpdateConsultantProfilService {
    public static Consultant updateConsultantProfil(String firstName, String lastName, Float averageDailyRate, List<String> skills,
                                                    List<Disponibility> disponibilities, PayementMode payementMode){
        return new Consultant(firstName, lastName, averageDailyRate, skills, disponibilities, payementMode);
    }
}
