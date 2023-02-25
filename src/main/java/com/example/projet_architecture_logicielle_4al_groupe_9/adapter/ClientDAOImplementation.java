package com.example.projet_architecture_logicielle_4al_groupe_9.adapter;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.infrastructure.SQL;
import com.example.projet_architecture_logicielle_4al_groupe_9.port.ClientDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImplementation implements ClientDAO {
    @Override
    public List<Consultant> getConsultants() {
        SQL sql = new SQL();
        List<Consultant> consultants = sql.getConsultantList();
        sql.close();
        return consultants;
    }

    @Override
    public Consultant findConsultantByName(String name){
        SQL sql = new SQL();
        Consultant consultant = sql.getConsultantByLastName(name);
        sql.close();
        return consultant;
    }
}
