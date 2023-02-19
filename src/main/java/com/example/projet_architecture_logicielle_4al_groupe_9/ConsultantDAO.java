package com.example.projet_architecture_logicielle_4al_groupe_9;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ConsultantDAO {
    public static List<Consultant> getConsultants() {
        return ConsultantList.consultantList;
    }

    public void addConsultant(Consultant consultant){
        SaveConsultantDatabaseService.saveConsultant(consultant);
    }

    public void updateConsultant(UUID id, Consultant consultant){
        UpdateConsultantDatabaseService.updateConsultant(id, consultant);
    }

    public List<Consultant> findConsultantByName(String name){
        return FindConsultantDatabaseService.findConsultantByName(name);
    }
}
