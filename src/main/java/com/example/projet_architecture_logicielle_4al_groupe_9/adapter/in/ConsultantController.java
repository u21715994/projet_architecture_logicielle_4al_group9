package com.example.projet_architecture_logicielle_4al_groupe_9.adapter.in;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.ConsultantDAO;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController

public class ConsultantController {
    @Autowired
    private ConsultantDAO consultantDAO;
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
    public ResponseEntity<Object> putConsultant(@PathVariable String id, @RequestBody Consultant consultant){
        consultantDAO.updateConsultant(id, consultant);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consultant.getID())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
