package com.example.projet_architecture_logicielle_4al_groupe_9.application.services;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Disponibility;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;

import java.util.ArrayList;
import java.util.List;

public class FindConsultantDatabaseService {
    public static List<Consultant> findConsultantByName(String name){
        List<Consultant> consultantFound = new ArrayList<>();
        for(Consultant consultant: PlateformConsultant.consultantList.values()){
            if(consultant.getFirstName().equals(name) || consultant.getLastName().equals(name)) {
                consultantFound.add(consultant);
            }
        }
        return consultantFound;
    }

    public static Consultant findConsultant(Disponibility disponibility){
        return null;
    }
}
