package com.example.projet_architecture_logicielle_4al_groupe_9;

import com.example.projet_architecture_logicielle_4al_groupe_9.application.services.SaveConsultantDatabaseService;
import com.example.projet_architecture_logicielle_4al_groupe_9.application.services.UpdateConsultantDatabaseService;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.ConsultantDAO;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ConsultantDAOImplementation implements ConsultantDAO {
    @Override
    public void addConsultant(Consultant consultant){
        SaveConsultantDatabaseService.saveConsultant(consultant);
    }

    @Override
    public void updateConsultant(UUID id, Consultant consultant){
        UpdateConsultantDatabaseService.updateConsultant(id, consultant);
    }
}
