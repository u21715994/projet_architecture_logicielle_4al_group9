package com.example.projet_architecture_logicielle_4al_groupe_9.modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.stream.Collectors;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.*;

public class SQL {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://91.121.230.45:3306/ArchiLogiciel";
    private static final String USER = "ArchiLogiciel";
    private static final String PASS = "%FyKr08_*-mkG34P";

    private Connection conn;

    public SQL() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connexion à la base de données réussie !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement du driver JDBC : " + e.getMessage());
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }
    }

    public void addConsultant(Consultant consultant) {
        String sql = "INSERT INTO consultant (nom, prenom, tjm, competence, disponibilite, mode_paiement) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, consultant.getLastName());
            statement.setString(2, consultant.getFirstName());
            statement.setFloat(3, consultant.getAverageDailyRate());
            statement.setString(4, String.join(",", consultant.getSkills()));
            List<Disponibility> disponibilities = consultant.getDisponibilities();
            String disponibilitiesStr = String.join(",", disponibilities.stream().map(Enum::toString).collect(Collectors.toList()));
            statement.setString(5, disponibilitiesStr);
            statement.setString(6, consultant.getPaymentMode().toString());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    consultant.setID(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du consultant à la base de données : " + e.getMessage());
        }
    }

    public void updateConsultant(String id, Consultant consultant) {
        String sql = "UPDATE consultant SET nom = ?, prenom = ?, tjm = ?, competence = ?, disponibilite = ?, mode_paiement = ? WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, consultant.getLastName());
            statement.setString(2, consultant.getFirstName());
            statement.setFloat(3, consultant.getAverageDailyRate());
            statement.setString(4, String.join(",", consultant.getSkills()));
            List<Disponibility> disponibilities = consultant.getDisponibilities();
            String disponibilitiesStr = String.join(",", disponibilities.stream().map(Enum::toString).collect(Collectors.toList()));
            statement.setString(5, disponibilitiesStr);
            statement.setString(6, consultant.getPaymentMode().toString());
            statement.setString(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du consultant dans la base de données : " + e.getMessage());
        }
    }

    public void deleteConsultant(String id) {
        String sql = "DELETE FROM consultant WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du consultant dans la base de données : " + e.getMessage());
        }
    }

    public List<Consultant> getConsultantList() {
        String sql = "SELECT * FROM consultant";
        Consultant consultant = null;
        List<Consultant> consultants = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("prenom");
                String lastName = resultSet.getString("nom");
                Float averageDailyRate = resultSet.getFloat("tjm");
                String[] skills = resultSet.getString("competence").split(",");
                List<String> skillsList = new ArrayList<>();
                for (String skill : skills) {
                    skillsList.add(skill);
                }
                String disponibilitiesStr = resultSet.getString("disponibilite");
                String[] disponibilitiesArr = disponibilitiesStr.split(",");
                List<Disponibility> disponibilities = new ArrayList<>();
                for (String disponibilityStr : disponibilitiesArr) {
                    disponibilities.add(Disponibility.valueOf(disponibilityStr));
                }
                PayementMode payementMode = PayementMode.valueOf(resultSet.getString("mode_paiement"));
                consultant = new Consultant(firstName, lastName, averageDailyRate, skillsList, disponibilities, payementMode);
                consultants.add(consultant);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du consultant dans la base de données : " + e.getMessage());
        }
        return consultants;
    }

    public Consultant getConsultant(String id) {
        String sql = "SELECT * FROM consultant WHERE id = ?";
        Consultant consultant = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("prenom");
                String lastName = resultSet.getString("nom");
                Float averageDailyRate = resultSet.getFloat("tjm");
                String[] skills = resultSet.getString("competence").split(",");
                List<String> skillsList = new ArrayList<>();
                for (String skill : skills) {
                    skillsList.add(skill);
                }
                String disponibilitiesStr = resultSet.getString("disponibilite");
                String[] disponibilitiesArr = disponibilitiesStr.split(",");
                List<Disponibility> disponibilities = new ArrayList<>();
                for (String disponibilityStr : disponibilitiesArr) {
                    disponibilities.add(Disponibility.valueOf(disponibilityStr));
                }
                PayementMode payementMode = PayementMode.valueOf(resultSet.getString("mode_paiement"));
                consultant = new Consultant(firstName, lastName, averageDailyRate, skillsList, disponibilities, payementMode);
                consultant.setID(id);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du consultant dans la base de données : " + e.getMessage());
        }
        return consultant;
    }

    public void addClient(String nom) {
        String sql = "INSERT INTO client (nom) VALUES (?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nom);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du client dans la base de données : " + e.getMessage());
        }
    }

    public Client getClientByName(String name) {
        String sql = "SELECT * FROM client WHERE nom = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String id = result.getString("id");
                return new Client(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client dans la base de données : " + e.getMessage());
        }
        return null;
    }

    public void updateClient(String id, String nom) {
        String sql = "UPDATE client SET nom = ? WHERE nom = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nom);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du client dans la base de données : " + e.getMessage());
        }
    }

    public void deleteClient(String name) {
        String sql = "DELETE FROM client WHERE nom = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du client dans la base de données : " + e.getMessage());
        }
    }

    public Consultant getConsultantByLastName(String lastName) {
        String sql = "SELECT * FROM consultant WHERE nom = ?";
        Consultant consultant = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("prenom");
                Float averageDailyRate = resultSet.getFloat("tjm");
                String[] skills = resultSet.getString("competence").split(",");
                List<String> skillsList = new ArrayList<>();
                for (String skill : skills) {
                    skillsList.add(skill);
                }
                String disponibilitiesStr = resultSet.getString("disponibilite");
                String[] disponibilitiesArr = disponibilitiesStr.split(",");
                List<Disponibility> disponibilities = new ArrayList<>();
                for (String disponibilityStr : disponibilitiesArr) {
                    try {
                        Disponibility disponibility = Disponibility.valueOf(disponibilityStr);
                        disponibilities.add(disponibility);
                    } catch (IllegalArgumentException e) {
                        System.err.println("La disponibilité " + disponibilityStr + " n'existe pas !");
                    }
                }
                PayementMode paymentMode = PayementMode.valueOf(resultSet.getString("mode_paiement"));
                consultant = new Consultant(firstName, lastName, averageDailyRate, skillsList, disponibilities, paymentMode);
                consultant.setID(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du consultant dans la base de données : " + e.getMessage());
        }
        return consultant;
    }

    public Client getClientByNom(String nom) {
        String sql = "SELECT * FROM client WHERE nom = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String id = result.getString("id");
                return new Client(nom);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client par nom dans la base de données : " + e.getMessage());
        }
        return null;
    }

}
