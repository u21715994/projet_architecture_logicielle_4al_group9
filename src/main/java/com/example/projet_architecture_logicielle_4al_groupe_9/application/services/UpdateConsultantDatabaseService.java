package com.example.projet_architecture_logicielle_4al_groupe_9.application.services;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;

import java.util.UUID;

public class UpdateConsultantDatabaseService {
    public static void updateConsultant(UUID id, Consultant consultant){
        PlateformConsultant.consultantList.put(id.toString(), consultant);
    }
}
