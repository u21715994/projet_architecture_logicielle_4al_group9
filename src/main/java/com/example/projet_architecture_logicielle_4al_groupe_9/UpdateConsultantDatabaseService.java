package com.example.projet_architecture_logicielle_4al_groupe_9;

import java.util.UUID;

public class UpdateConsultantDatabaseService {
    public static void updateConsultant(UUID id, Consultant consultant){
        for(Consultant consultant1: ConsultantList.consultantList){
            if(consultant1.getID().equals(id.toString()))
                consultant1 = new Consultant(consultant);
        }
    }
}
