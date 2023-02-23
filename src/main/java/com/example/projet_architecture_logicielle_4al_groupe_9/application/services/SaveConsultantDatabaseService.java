package com.example.projet_architecture_logicielle_4al_groupe_9.application.services;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.modele.SQL;

public class SaveConsultantDatabaseService {
    public static void saveConsultant(Consultant consultant){
        SQL database = new SQL();
        database.addConsultant(consultant);
        database.close();
        PlateformConsultant.consultantList.put(consultant.getID(), consultant);
    }
}
