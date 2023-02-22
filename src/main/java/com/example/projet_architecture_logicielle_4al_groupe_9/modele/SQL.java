package com.example.projet_architecture_logicielle_4al_groupe_9.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    private final String IP = "91.121.230.45";
    private final int PORT = 3306;
    private final String USER = "ArchiLogiciel";
    private final String NOM_BDD = "ArchiLogiciel";
    private final String MDP = "%FyKr08_*-mkG34P";
    private Connection connexion;

    public SQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + NOM_BDD, USER, MDP);
            System.out.println("Connexion à la base de données réussie.");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de chargement du driver MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données.");
            e.printStackTrace();
        }
    }
}
