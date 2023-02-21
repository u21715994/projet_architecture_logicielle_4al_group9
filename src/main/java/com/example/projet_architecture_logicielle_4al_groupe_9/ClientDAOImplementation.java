package com.example.projet_architecture_logicielle_4al_groupe_9;

import com.example.projet_architecture_logicielle_4al_groupe_9.application.services.FindConsultantDatabaseService;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.ClientDAO;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClientDAOImplementation implements ClientDAO {
    @Override
    public Map<String, Consultant> getConsultants() {
        return PlateformConsultant.consultantList;
    }

    @Override
    public List<Consultant> findConsultantByName(String name){
        return FindConsultantDatabaseService.findConsultantByName(name);
    }
}
