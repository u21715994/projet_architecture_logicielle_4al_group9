package com.example.projet_architecture_logicielle_4al_groupe_9.port;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;

import java.util.List;
import java.util.Map;

public interface ClientDAO {
    public List<Consultant> getConsultants();

    public Consultant findConsultantByName(String name);
}
