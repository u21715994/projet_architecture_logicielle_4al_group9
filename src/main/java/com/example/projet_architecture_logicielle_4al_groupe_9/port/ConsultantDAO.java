package com.example.projet_architecture_logicielle_4al_groupe_9.port;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;

public interface ConsultantDAO {
    public void addConsultant(Consultant consultant);

    public void updateConsultant(String id, Consultant consultant);
}
