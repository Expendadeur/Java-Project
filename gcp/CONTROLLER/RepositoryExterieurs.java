/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Consommable;
import gcp.MODELES.Equipement;
import gcp.MODELES.Tarifications;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepositoryExterieurs {
    
    // Méthode pour ajouter un consommable
    public void addConsommable(Consommable consommable) {
        String sql = "INSERT INTO Consommable (Nom_Consommable, Quantité, Date_Achat) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consommable.getNomConsommable());
            pstmt.setInt(2, consommable.getQuantite());
            pstmt.setString(3, consommable.getDateAchat());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire tous les consommables
    public List<Consommable> readAllConsommables() {
        List<Consommable> consommables = new ArrayList<>();
        String sql = "SELECT * FROM Consommable";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consommable consommable = new Consommable(
                    
                    rs.getString("Nom_Consommable"),
                    rs.getInt("Quantité"),
                    rs.getString("Date_Achat"),
                    rs.getInt("Id_Consommable")
                );
                consommables.add(consommable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommables;
    }

    // Méthode pour mettre à jour un consommable
    public void updateConsommable(Consommable consommable) {
        String sql = "UPDATE Consommable SET Nom_Consommable = ?, Quantité = ?, Date_Achat = ? WHERE Id_Consommable = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consommable.getNomConsommable());
            pstmt.setInt(2, consommable.getQuantite());
            pstmt.setString(3,consommable.getDateAchat());
            pstmt.setInt(4, consommable.getIdConsommable());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un consommable
    public void deleteConsommable(int idConsommable) {
        String sql = "DELETE FROM Consommable WHERE Id_Consommable = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idConsommable);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un équipement
    public void addEquipement(Equipement equipement) {
        String sql = "INSERT INTO Equipement (Nom_Equipement, Type_Equipement, Date_Achat, État) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, equipement.getNomEquipement());
            pstmt.setString(2, equipement.getTypeEquipement());
            pstmt.setDate(3, new java.sql.Date(equipement.getDateAchat().getTime()));
            pstmt.setString(4, equipement.getEtat());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire tous les équipements
    public List<Equipement> readAllEquipements() {
        List<Equipement> equipements = new ArrayList<>();
        String sql = "SELECT * FROM Equipement";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Equipement equipement = new Equipement(
                    rs.getString("Nom_Equipement"),
                    rs.getString("Type_Equipement"),
                    rs.getDate("Date_Achat"),
                    rs.getString("État"),
                    rs.getInt("Id_Equipement")
                );
                equipements.add(equipement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipements;
    }

    // Méthode pour mettre à jour un équipement
    public void updateEquipement(Equipement equipement) {
        String sql = "UPDATE Equipement SET Nom_Equipement = ?, Type_Equipement = ?, Date_Achat = ?, État = ? WHERE Id_Equipement = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, equipement.getNomEquipement());
            pstmt.setString(2, equipement.getTypeEquipement());
            pstmt.setDate(3, new java.sql.Date(equipement.getDateAchat().getTime()));
            pstmt.setString(4, equipement.getEtat());
            pstmt.setInt(5, equipement.getIdEquipement());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un équipement
    public void deleteEquipement(int idEquipement) {
        String sql = "DELETE FROM Equipement WHERE Id_Equipement = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEquipement);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
            // Méthode pour trouver les dépêches par destination
    public List<Equipement> findEquipementByNom(String noms) {
        List<Equipement> equipements= new ArrayList<>();
        String sql = "SELECT * FROM Equipement WHERE Nom_Equipement = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,noms);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
 Equipement equipement = new Equipement(
                    rs.getString("Nom_Equipement"),
                    rs.getString("Type_Equipement"),
                    rs.getDate("Date_Achat"),
                    rs.getString("État")
                );
                equipements.add(equipement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipements;
    }

    // Méthode pour ajouter une tarification
    public void addTarification(Tarifications tarification) {
        String sql = "INSERT INTO Tarification (Type_Courrier, Tarif, Date_Validité) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tarification.getTypeCourrier());
            pstmt.setDouble(2, tarification.getTarif());
            pstmt.setDate(3,new java.sql.Date(tarification.getDateValidite().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire toutes les tarifications
    public List<Tarifications> readAllTarifications() {
        List<Tarifications> tarifications = new ArrayList<>();
        String sql = "SELECT * FROM Tarification";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tarifications tarification = new Tarifications(
                    rs.getString("Type_Courrier"),
                    rs.getDouble("Tarif"),
                    rs.getDate("Date_Validité"),
                    rs.getInt("Id_Tarif")
                );
                tarifications.add(tarification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarifications;
    }
    
        // Méthode pour trouver les dépêches par destination
    public List<Tarifications> findTarificationByNom(String noms) {
        List<Tarifications> tarifications= new ArrayList<>();
        String sql = "SELECT * FROM Tarification WHERE Type_Courrier = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,noms);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
Tarifications tarification = new Tarifications(
                    rs.getString("Type_Courrier"),
                    rs.getDouble("Tarif"),
                    rs.getDate("Date_Validité"),
                    rs.getInt("Id_Tarif")
                );
                tarifications.add(tarification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarifications;
    }

    // Méthode pour mettre à jour une tarification
    public void updateTarification(Tarifications tarification) {
        String sql = "UPDATE Tarification SET Type_Courrier = ?, Tarif = ?, Date_Validité = ? WHERE Id_Tarif = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tarification.getTypeCourrier());
            pstmt.setDouble(2, tarification.getTarif());
            pstmt.setDate(3, new java.sql.Date(tarification.getDateValidite().getTime()));
            pstmt.setInt(4, tarification.getIdTarif());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une tarification
    public void deleteTarification(int idTarif) {
        String sql = "DELETE FROM Tarification WHERE Id_Tarif = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTarif);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
