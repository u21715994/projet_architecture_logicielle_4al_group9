package com.example.projet_architecture_logicielle_4al_groupe_9;

import java.util.UUID;

public class UpdateConsultantDatabaseService {
    public static void updateConsultant(UUID id, Consultant consultant){
        ConsultantList.consultantList.put(id.toString(), consultant);
    }
}
