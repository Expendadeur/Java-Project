/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Employe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class RepositoryEmploye {
  public void createEmploye(Employe employe) {
        String insertQuery = "INSERT INTO Employe (Nom_Employe, Prenom_Employe, Matricule, " +
                             "DateNaiss_Employe, DateEmb_Employe, NumTel_Employe, Pswd_Employe, " +
                             "Login_Employe, Id_Service, Id_Agence,Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
             
            pstmt.setString(1, employe.getNomEmploye());
            pstmt.setString(2, employe.getPrenomEmploye());
            pstmt.setString(3, employe.getMatricule());
            pstmt.setDate(4, new java.sql.Date(employe.getDateNaiss().getTime()));
            pstmt.setDate(5, new java.sql.Date(employe.getDateEmb().getTime()));
            pstmt.setString(6, employe.getNumTel());
           
            // Hachage du mot de passe avant insertion
            String hashedPassword = BCrypt.hashpw(employe.getPswd(), BCrypt.gensalt());
            pstmt.setString(7, hashedPassword);  // Utilisez le mot de passe haché
            
            pstmt.setString(8, employe.getLogin());
            pstmt.setInt(9, employe.getIdService());
            pstmt.setInt(10, employe.getIdAgence());
            pstmt.setString(11, employe.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Lire tous les employés
    public List<Employe> readAllEmployes() {
        List<Employe> employes = new ArrayList<>();
        String selectQuery = "SELECT * FROM Employe";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(selectQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Employe employe = new Employe(
                    rs.getString("Nom_Employe"),
                    rs.getString("Prenom_Employe"),
                    rs.getString("Matricule"),
                    rs.getDate("DateNaiss_Employe"),
                    rs.getDate("DateEmb_Employe"),
                    rs.getString("NumTel_Employe"),
                    rs.getString("Pswd_Employe"),
                    rs.getString("Login_Employe"),
                    rs.getInt("Id_Service"),
                    rs.getInt("Id_Agence"),
                    rs.getInt("IdEmploye")
                );
                employes.add(employe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employes;
    }

    // UPDATE - Mettre à jour un employé
    public void updateEmploye(Employe employe) {
        String updateQuery = "UPDATE Employe SET Nom_Employe = ?, Prenom_Employe = ?, Matricule = ?, " +
                             "DateNaiss_Employe = ?, DateEmb_Employe = ?, NumTel_Employe = ?, " +
                             "Pswd_Employe = ?, Login_Employe = ?, Id_Service = ?, Id_Agence = ? " +
                             "WHERE IdEmploye = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {

            pstmt.setString(1, employe.getNomEmploye());
            pstmt.setString(2, employe.getPrenomEmploye());
            pstmt.setString(3, employe.getMatricule());
            pstmt.setDate(4, new java.sql.Date(employe.getDateNaiss().getTime()));
            pstmt.setDate(5, new java.sql.Date(employe.getDateEmb().getTime()));
            pstmt.setString(6, employe.getNumTel());
            pstmt.setString(7, employe.getPswd());
            pstmt.setString(8, employe.getLogin());
            pstmt.setInt(9, employe.getIdService());
            pstmt.setInt(10, employe.getIdAgence());
            pstmt.setInt(11, employe.getIdEmploye());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Supprimer un employé
    public void deleteEmploye(int idEmploye) {
        String deleteQuery = "DELETE FROM Employe WHERE IdEmploye = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {

            pstmt.setInt(1, idEmploye);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
