/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Agences;
import gcp.MODELES.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryAgence {
  // CREATE - Ajouter une nouvelle agence
    public void createAgence(Agences agence) {
        String insertQuery = "INSERT INTO Agence (Nom_Agence, Adresse, Ville, Pays, Num_Tel) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            pstmt.setString(1, agence.getNomAgence());
            pstmt.setString(2, agence.getAdresse());
            pstmt.setString(3, agence.getVille());
            pstmt.setString(4, agence.getPays());
            pstmt.setString(5, agence.getNumTel());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Lire toutes les agences
    public List<Agences> readAllAgences() {
        List<Agences> agences = new ArrayList<>();
        String selectQuery = "SELECT * FROM Agence";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Agences agence = new Agences(
                    rs.getString("Nom_Agence"),
                    rs.getString("Adresse"),
                    rs.getString("Ville"),
                    rs.getString("Pays"),
                    rs.getString("Num_Tel"),
                    rs.getInt("Id_Agence")
                );
                agences.add(agence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agences;
    }

    // UPDATE - Mettre à jour une agence
    public void updateAgence(Agences agence) {
        String updateQuery = "UPDATE Agence SET Nom_Agence = ?, Adresse = ?, Ville = ?, Pays = ?, Num_Tel = ? WHERE Id_Agence = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {

            pstmt.setString(1, agence.getNomAgence());
            pstmt.setString(2, agence.getAdresse());
            pstmt.setString(3, agence.getVille());
            pstmt.setString(4, agence.getPays());
            pstmt.setString(5, agence.getNumTel());
            pstmt.setInt(6, agence.getIdAgence());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Supprimer une agence
  public void deleteAgence(int idAgence) {
    // Supprimer d'abord les employés et courriers associés
    String deleteEmployesQuery = "DELETE FROM Employe WHERE Id_Agence = ?";
    String deleteCourriersQuery = "DELETE FROM Courrier WHERE Id_Agence = ?";

    try (Connection connection = DatabaseConnection.getConnection()) {
        // Supprimer les employés
        try (PreparedStatement pstmt = connection.prepareStatement(deleteEmployesQuery)) {
            pstmt.setInt(1, idAgence);
            pstmt.executeUpdate();
        }

        // Supprimer les courriers
        try (PreparedStatement pstmt = connection.prepareStatement(deleteCourriersQuery)) {
            pstmt.setInt(1, idAgence);
            pstmt.executeUpdate();
        }
        // Ensuite, supprimer l'agence
        String deleteQuery = "DELETE FROM Agence WHERE Id_Agence = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idAgence);
            pstmt.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // RECHERCHE - Rechercher des agences par nom (ou autres critères) avec LIKE
    public List<Agences> searchAgences(String keyword) {
        List<Agences> agences = new ArrayList<>();
        String searchQuery = "SELECT * FROM Agence WHERE Nom_Agence LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(searchQuery)) {

            pstmt.setString(1, "%" + keyword + "%"); // Utilisation de LIKE
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Agences agence = new Agences(
                    
                    rs.getString("Nom_Agence"),
                    rs.getString("Adresse"),
                    rs.getString("Ville"),
                    rs.getString("Pays"),
                    rs.getString("Num_Tel"),
                    rs.getInt("Id_Agence")
                );
                agences.add(agence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agences;
    }
    
    
    // CREATE - Ajouter un nouveau service
    public void createService(Service service) {
        String insertQuery = "INSERT INTO Service (Nom_Service) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            pstmt.setString(1, service.getNomService());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Lire tous les services
    public List<Service> readAllServices() {
        List<Service> services = new ArrayList<>();
        String selectQuery = "SELECT * FROM Service";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Service service = new Service(
                    rs.getInt("Id_Service"),
                    rs.getString("Nom_Service")
                );
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    // UPDATE - Mettre à jour un service
    public void updateService(Service service) {
        String updateQuery = "UPDATE Service SET Nom_Service = ? WHERE Id_Service = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {

            pstmt.setString(1, service.getNomService());
            pstmt.setInt(2, service.getIdService());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Supprimer un service
    public void deleteService(int idService) {
        String deleteQuery = "DELETE FROM Service WHERE Id_Service = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idService);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
