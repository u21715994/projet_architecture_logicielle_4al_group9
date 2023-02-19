package com.example.projet_architecture_logicielle_4al_groupe_9;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("consultant_list")
public class ConsultantList {
    static List<Consultant> consultantList = new ArrayList<>();
}
