package com.example.projet_architecture_logicielle_4al_groupe_9;

import java.util.ArrayList;
import java.util.List;

public class FindConsultantDatabaseService {
    public static List<Consultant> findConsultantByName(String name){
        List<Consultant> consultantFound = new ArrayList<>();
        for(Consultant consultant: ConsultantList.consultantList){
            if(consultant.firstName.equals(name) || consultant.lastName.equals(name)) {
                consultantFound.add(consultant);
            }
        }
        return consultantFound;
    }

    public static Consultant findConsultant(Disponibility disponibility){
        return null;
    }
}
