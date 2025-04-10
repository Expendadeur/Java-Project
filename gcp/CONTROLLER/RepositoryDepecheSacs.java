/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Depeche;
import gcp.MODELES.SacInterne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ISSA 2025
 */
public class RepositoryDepecheSacs {
     
    // Méthode pour ajouter une dépêche
    public void addDepêche(Depeche dépêche) {
        String sql = "INSERT INTO Dépêche (Id_Dépêche, Poids_Dépêche, Origine_Dépêche, Destination_Dépêche, Description) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dépêche.getIdDepeche());
            pstmt.setDouble(2, dépêche.getPoidsDepeche());
            pstmt.setString(3, dépêche.getOrigineDepeche());
            pstmt.setString(4, dépêche.getDestinationDepeche());
            pstmt.setString(5, dépêche.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire toutes les dépêches
    public List<Depeche> readAllDépêches() {
        List<Depeche> dépêches = new ArrayList<>();
        String sql = "SELECT * FROM Dépêche";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Depeche dépêche = new Depeche(
                    rs.getString("Id_Dépêche"),
                    rs.getDouble("Poids_Dépêche"),
                    rs.getString("Origine_Dépêche"),
                    rs.getString("Destination_Dépêche"),
                    rs.getString("Description")
                );
                dépêches.add(dépêche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dépêches;
    }

    // Méthode pour mettre à jour une dépêche
    public void updateDepêche(Depeche dépêche) {
        String sql = "UPDATE Dépêche SET Poids_Dépêche = ?, Origine_Dépêche = ?, Destination_Dépêche = ?, Description = ? WHERE Id_Dépêche = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, dépêche.getPoidsDepeche());
            pstmt.setString(2, dépêche.getOrigineDepeche());
            pstmt.setString(3, dépêche.getDestinationDepeche());
            pstmt.setString(4, dépêche.getDescription());
            pstmt.setString(5, dépêche.getIdDepeche());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une dépêche
    public void deleteDepêche(String idDépêche) {
        String sql = "DELETE FROM Dépêche WHERE Id_Dépêche = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idDépêche);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un sac interne
    public void addSacInterne(SacInterne sacInterne) {
        String sql = "INSERT INTO SacInterne (Poids_SacInterne,regime,region, Details_SacInterne) VALUES (?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, sacInterne.getPoidsSacInterne());
            pstmt.setString(2, sacInterne.getRegime());
            pstmt.setString(3, sacInterne.getRegion());
            pstmt.setString(4, sacInterne.getDetailsSacInterne());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire tous les sacs internes
    public List<SacInterne> readAllSacsInternes() {
        List<SacInterne> sacsInternes = new ArrayList<>();
        String sql = "SELECT * FROM SacInterne";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SacInterne sacInterne = new SacInterne(
                    rs.getInt("Id_SacPetitSac"),
                    rs.getDouble("Poids_SacInterne"),
                    rs.getString("regime"),
                    rs.getString("region"),
                    rs.getString("Details_SacInterne")
                );
                sacsInternes.add(sacInterne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sacsInternes;
    }

    // Méthode pour mettre à jour un sac interne
    public void updateSacInterne(SacInterne sacInterne) {
        String sql = "UPDATE SacInterne SET Poids_SacInterne = ?,regime = ?,region = ?, Details_SacInterne = ? WHERE Id_SacPetitSac = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, sacInterne.getPoidsSacInterne());
            pstmt.setString(2, sacInterne.getRegime());
            pstmt.setString(3, sacInterne.getRegion());
            pstmt.setString(4, sacInterne.getDetailsSacInterne());
            pstmt.setInt(5, sacInterne.getIdSacPetitSac());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un sac interne
    public void deleteSacInterne(int idSacPetitSac) {
        String sql = "DELETE FROM SacInterne WHERE Id_SacPetitSac = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idSacPetitSac);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        // Méthode pour trouver les dépêches par destination
    public List<Depeche> findDépêchesByDestination(String destination) {
        List<Depeche> dépêches = new ArrayList<>();
        String sql = "SELECT * FROM Dépêche WHERE Destination_Dépêche = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, destination);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Depeche dépêche = new Depeche(
                    rs.getString("Id_Dépêche"),
                    rs.getDouble("Poids_Dépêche"),
                    rs.getString("Origine_Dépêche"),
                    rs.getString("Destination_Dépêche"),
                    rs.getString("Description")
                );
                dépêches.add(dépêche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dépêches;
    }

    // Méthode pour trouver les sacs internes par destination
    public List<SacInterne> findSacsByDestination(String destination) {
        List<SacInterne> sacsInternes = new ArrayList<>();
        String sql = "SELECT * FROM SacInterne WHERE Details_SacInterne = ?"; // Supposons que la colonne pour le lien soit Details_SacInterne

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, destination); // Adaptez si nécessaire
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SacInterne sacInterne = new SacInterne(
                    rs.getInt("Id_SacPetitSac"),
                    rs.getDouble("Poids_SacInterne"),
                    rs.getString("regime"),
                    rs.getString("region"),
                    rs.getString("Details_SacInterne")
                );
                sacsInternes.add(sacInterne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sacsInternes;
    }
}
