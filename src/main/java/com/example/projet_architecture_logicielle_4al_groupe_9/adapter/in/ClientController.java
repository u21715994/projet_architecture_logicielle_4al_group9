package com.example.projet_architecture_logicielle_4al_groupe_9.adapter.in;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.ClientDAO;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class ClientController {
    @Autowired
    private ClientDAO clientDAO;

    @GetMapping(
            path = "/consultants",
            produces = "application/json"
    )
    public Map<String, Consultant> getConsultants(){
        return clientDAO.getConsultants();
    }

    @GetMapping(
            path = "/consultants/{name}",
            produces = "application/json"
    )
    public List<Consultant> findConsultantByName(@PathVariable String name){
        return clientDAO.findConsultantByName(name);
    }
}
