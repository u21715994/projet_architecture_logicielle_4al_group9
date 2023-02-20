package com.example.projet_architecture_logicielle_4al_groupe_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController

public class ConsultantController {
    @Autowired
    private ConsultantDAO consultantDAO;

    @GetMapping(
            path = "/consultants",
            produces = "application/json"
    )
    public Map<String, Consultant> getConsultants(){
        return consultantDAO.getConsultants();
    }

    @PostMapping(
            path = "/consultants",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> postConsultant(@RequestBody Consultant consultant){
        consultantDAO.addConsultant(consultant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(
            path = "/consultants/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> putConsultant(@PathVariable UUID id, @RequestBody Consultant consultant){
        consultantDAO.updateConsultant(id, consultant);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consultant.getID())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(
            path = "/consultants/{name}",
            produces = "application/json"
    )
    public List<Consultant> findConsultantByName(@PathVariable String name){
        return consultantDAO.findConsultantByName(name);
    }
}
