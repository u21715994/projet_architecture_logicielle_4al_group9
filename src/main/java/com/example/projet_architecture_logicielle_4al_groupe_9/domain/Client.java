package com.example.projet_architecture_logicielle_4al_groupe_9.domain;

public class Client {
    private final String id;
    private final String name;

    public Client(String name) {
        this.id = "0"; // L'ID sera généré automatiquement lors de l'insertion en base de données
        this.name = name;
    }

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}