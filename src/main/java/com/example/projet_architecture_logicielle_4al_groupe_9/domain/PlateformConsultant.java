package com.example.projet_architecture_logicielle_4al_groupe_9.domain;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.HashMap;
import java.util.Map;

@JsonRootName("consultant_list")
public class PlateformConsultant {
    public static Map<String, Consultant> consultantList = new HashMap<>();
}
