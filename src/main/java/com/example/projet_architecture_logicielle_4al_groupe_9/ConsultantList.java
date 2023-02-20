package com.example.projet_architecture_logicielle_4al_groupe_9;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonRootName("consultant_list")
public class ConsultantList {
    static Map<String, Consultant> consultantList = new HashMap<>();
}
