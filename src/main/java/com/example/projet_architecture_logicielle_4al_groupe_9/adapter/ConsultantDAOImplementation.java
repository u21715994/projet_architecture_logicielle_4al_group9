package com.example.projet_architecture_logicielle_4al_groupe_9.adapter;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PlateformConsultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.infrastructure.SQL;
import com.example.projet_architecture_logicielle_4al_groupe_9.port.ConsultantDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultantDAOImplementation implements ConsultantDAO {
    @Override
    public void addConsultant(Consultant consultant){
        SQL database = new SQL();
        database.addConsultant(consultant);
        database.close();
        PlateformConsultant.consultantList.put(consultant.getID(), consultant);
    }

    @Override
    public void updateConsultant(String id, Consultant consultant){
        System.out.println(consultant);
        SQL database = new SQL();
        database.updateConsultant(id, consultant);
        database.close();
        PlateformConsultant.consultantList.put(id.toString(), consultant);
    }
}
