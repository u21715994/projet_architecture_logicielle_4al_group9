package com.example.projet_architecture_logicielle_4al_groupe_9.domain;

import com.example.projet_architecture_logicielle_4al_groupe_9.application.services.FindConsultantDatabaseService;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;

import java.util.List;
import java.util.Map;

public interface ClientDAO {
    public Map<String, Consultant> getConsultants();

    public List<Consultant> findConsultantByName(String name);
}
