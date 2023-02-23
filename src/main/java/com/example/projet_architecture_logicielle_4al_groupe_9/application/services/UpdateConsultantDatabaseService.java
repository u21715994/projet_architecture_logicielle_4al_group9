package com.example.projet_architecture_logicielle_4al_groupe_9.application.services;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.modele.SQL;

import java.util.UUID;

public class UpdateConsultantDatabaseService {
    public static void updateConsultant(String id, Consultant consultant){
        SQL database = new SQL();
        database.updateConsultant(id, consultant);
        database.close();
        PlateformConsultant.consultantList.put(id.toString(), consultant);
    }
}
