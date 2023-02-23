package com.example.projet_architecture_logicielle_4al_groupe_9.domain;

import com.example.projet_architecture_logicielle_4al_groupe_9.application.services.SaveConsultantDatabaseService;
import com.example.projet_architecture_logicielle_4al_groupe_9.application.services.UpdateConsultantDatabaseService;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;

import java.util.UUID;

public interface ConsultantDAO {
    public void addConsultant(Consultant consultant);

    public void updateConsultant(String id, Consultant consultant);
}
