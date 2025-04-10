/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Conduire;
import gcp.MODELES.Conduires;
import gcp.MODELES.Route;
import gcp.MODELES.Ville;
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
public class RepositoryAVRC {
     // CREATE - Ajouter une entrée dans toutes les tables
    public void createAll(Conduires conduire, Ville ville) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false); // Commencer une transaction

            // Insérer dans la table Automobile
            String insertAuto = "INSERT INTO Automobile (Num_Plaque, Marque_Automobile) VALUES (?, ?)";
            int idAutomobile = 0;
            try (PreparedStatement pstmtAuto = connection.prepareStatement(insertAuto, Statement.RETURN_GENERATED_KEYS)) {
                pstmtAuto.setString(1, conduire.getAutomobile().getNumPlaque());
                pstmtAuto.setString(2, conduire.getAutomobile().getMarqueAutomobile());
                pstmtAuto.executeUpdate();

                try (ResultSet generatedKeys = pstmtAuto.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idAutomobile = generatedKeys.getInt(1);
                    }
                }
            }

            // Insérer dans la table Ville
            String insertVille = "INSERT INTO Ville (GroupeVille, NomVille) VALUES (?, ?)";
            int idVille = 0;
            try (PreparedStatement pstmtVille = connection.prepareStatement(insertVille, Statement.RETURN_GENERATED_KEYS)) {
                pstmtVille.setString(1, ville.getGroupeVille());
                pstmtVille.setString(2, ville.getNomVille());
                pstmtVille.executeUpdate();

                try (ResultSet generatedKeys = pstmtVille.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idVille = generatedKeys.getInt(1);
                    }
                }
            }

            // Insérer dans la table Route
            String insertRoute = "INSERT INTO Route (NomRoute, VilleDépart, VilleEscale, Ville_Arrivé) VALUES (?, ?, ?, ?)";
            int idRoute = 0;
            try (PreparedStatement pstmtRoute = connection.prepareStatement(insertRoute, Statement.RETURN_GENERATED_KEYS)) {
                pstmtRoute.setString(1, "NomRoute"); // Remplacez par les valeurs appropriées
                pstmtRoute.setString(2, ville.getNomVille()); // Exemple
                pstmtRoute.setString(3, "VilleEscale"); // À définir
                pstmtRoute.setString(4, "VilleArrivee"); // À définir
                pstmtRoute.executeUpdate();

                try (ResultSet generatedKeys = pstmtRoute.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idRoute = generatedKeys.getInt(1);
                    }
                }
            }

            // Insérer dans la table Conduire
            String insertConduire = "INSERT INTO Conduire (Id_Employe, Id_Automobile, HeureDépart, HeureRetour) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmtConduire = connection.prepareStatement(insertConduire)) {
                pstmtConduire.setInt(1, conduire.getEmploye().getIdEmploye());
                pstmtConduire.setInt(2, idAutomobile);
                pstmtConduire.setString(3, conduire.getHeureDepart());
                pstmtConduire.setString(4, conduire.getHeureRetour());
                pstmtConduire.executeUpdate();
            }

            connection.commit(); // Confirmer la transaction
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Lire les enregistrements de toutes les tables par employé
    public List<String> readAllByEmploye(int idEmploye) {
        List<String> resultList = new ArrayList<>();
        String query = "SELECT a.Num_Plaque, a.Marque_Automobile, v.NomVille, r.NomRoute " +
                       "FROM Conduire c " +
                       "JOIN Automobile a ON c.Id_Automobile = a.Id_Automobile " +
                       "JOIN Ville v ON v.Id_Ville = (SELECT Id_Ville FROM Route WHERE c.Id_Route = r.Id_Route) " +
                       "JOIN Route r ON c.Id_Route = r.Id_Route " +
                       "WHERE c.Id_Employe = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idEmploye);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String result = "Plaque: " + rs.getString("Num_Plaque") +
                                ", Marque: " + rs.getString("Marque_Automobile") +
                                ", Ville: " + rs.getString("NomVille") +
                                ", Route: " + rs.getString("NomRoute");
                resultList.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    // UPDATE - Mettre à jour une automobile
    public void updateAutomobile(int idAutomobile, String numPlaque, String marque) {
        String updateQuery = "UPDATE Automobile SET Num_Plaque = ?, Marque_Automobile = ? WHERE Id_Automobile = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setString(1, numPlaque);
            pstmt.setString(2, marque);
            pstmt.setInt(3, idAutomobile);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Supprimer une automobile par ID
    public void deleteAutomobile(int idAutomobile) {
        String deleteQuery = "DELETE FROM Automobile WHERE Id_Automobile = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idAutomobile);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthodes pour Ville
    public void createVille(Ville ville) {
        String insertVille = "INSERT INTO Ville (GroupeVille, NomVille) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertVille, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, ville.getGroupeVille());
            pstmt.setString(2, ville.getNomVille());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ville> readAllVilles() {
        List<Ville> villes = new ArrayList<>();
        String query = "SELECT * FROM Ville";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Ville ville = new Ville(rs.getString("GroupeVille"), rs.getString("NomVille"));
                villes.add(ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return villes;
    }

    public void updateVille(int idVille, String groupeVille, String nomVille) {
        String updateQuery = "UPDATE Ville SET GroupeVille = ?, NomVille = ? WHERE Id_Ville = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setString(1, groupeVille);
            pstmt.setString(2, nomVille);
            pstmt.setInt(3, idVille);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVille(int idVille) {
        String deleteQuery = "DELETE FROM Ville WHERE Id_Ville = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idVille);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthodes pour Route
    public void createRoute(Route route) {
        String insertRoute = "INSERT INTO Route (NomRoute, VilleDépart, VilleEscale, Ville_Arrivé) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertRoute, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, route.getNomRoute());
            pstmt.setString(2, route.getVilleDepart());
            pstmt.setString(3, route.getVilleEscale());
            pstmt.setString(4, route.getVilleArrivee());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Route> readAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String query = "SELECT * FROM Route";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Route route = new Route(rs.getString("NomRoute"), rs.getString("VilleDépart"), 
                                        rs.getString("VilleEscale"), rs.getString("Ville_Arrivé"));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return routes;
    }

    public void updateRoute(int idRoute, String nomRoute, String villeDepart, String villeEscale, String villeArrivee) {
        String updateQuery = "UPDATE Route SET NomRoute = ?, VilleDépart = ?, VilleEscale = ?, Ville_Arrivé = ? WHERE Id_Route = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setString(1, nomRoute);
            pstmt.setString(2, villeDepart);
            pstmt.setString(3, villeEscale);
            pstmt.setString(4, villeArrivee);
            pstmt.setInt(5, idRoute);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoute(int idRoute) {
        String deleteQuery = "DELETE FROM Route WHERE Id_Route = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idRoute);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthodes pour Conduire
    public void createConduire(Conduires conduire) {
        String insertConduire = "INSERT INTO Conduire (Id_Employe, Id_Automobile, HeureDépart, HeureRetour) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertConduire)) {
            pstmt.setInt(1, conduire.getEmploye().getIdEmploye());
            pstmt.setInt(2, conduire.getAutomobile().getIdAutomobile());
            pstmt.setString(3, conduire.getHeureDepart());
            pstmt.setString(4, conduire.getHeureRetour());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conduire> readAllConduires() {
        List<Conduire> conduires = new ArrayList<>();
        String query = "SELECT * FROM Conduire";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // À adapter selon vos classes
                Conduire conduire = new Conduire(rs.getInt("Id_Employe"), rs.getInt("Id_Automobile"),
                                                  rs.getString("HeureDépart"), rs.getString("HeureRetour"));
                conduires.add(conduire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conduires;
    }

    public void updateConduire(int idConduire, int idEmploye, int idAutomobile, String heureDepart, String heureRetour) {
        String updateQuery = "UPDATE Conduire SET Id_Employe = ?, Id_Automobile = ?, HeureDépart = ?, HeureRetour = ? WHERE Id_Conduire = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setInt(1, idEmploye);
            pstmt.setInt(2, idAutomobile);
            pstmt.setString(3, heureDepart);
            pstmt.setString(4, heureRetour);
            pstmt.setInt(5, idConduire);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteConduire(int idConduire) {
        String deleteQuery = "DELETE FROM Conduire WHERE Id_Conduire = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idConduire);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
