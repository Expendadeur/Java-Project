package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Automobile;
import gcp.MODELES.Compagnie;
import gcp.MODELES.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RepositoryRouteVilleCampagnie {

    // Méthode unifiée pour créer des enregistrements dans toutes les tables
    public void createRecords(Compagnie compagnie, Automobile automobile, Route route) {
        String compagnieQuery = "INSERT INTO Compagnie ( Sigle_Compagnie, Nom_Compagnie) VALUES ( ?, ?)";
        String automobileQuery = "INSERT INTO Automobile ( Num_Plaque, Marque_Automobile) VALUES ( ?, ?)";
        String routeQuery = "INSERT INTO Route ( NomRoute, VilleDépart, VilleEscale, Ville_Arrivé) VALUES ( ?, ?, ?, ?)";

        Connection conn = null; // Déclarer conn ici

        try {
            conn = DatabaseConnection.getConnection(); // Initialiser conn ici
            if (conn == null) {
                throw new SQLException("Échec lors de la connexion ");
            }
            conn.setAutoCommit(false); // Désactiver l'auto-commit

            // Insérer dans Compagnie
            try (PreparedStatement pstmt = conn.prepareStatement(compagnieQuery)) {
                pstmt.setString(1, compagnie.getSigleCompagnie());
                pstmt.setString(2, compagnie.getNomCompagnie());
                pstmt.executeUpdate();
            }

            // Insérer dans Automobile
            try (PreparedStatement pstmt = conn.prepareStatement(automobileQuery)) {
                pstmt.setString(1, automobile.getNumPlaque());
                pstmt.setString(2, automobile.getMarqueAutomobile());
                pstmt.executeUpdate();
            }

            // Insérer dans Route
            try (PreparedStatement pstmt = conn.prepareStatement(routeQuery)) {
                pstmt.setString(1, route.getNomRoute());
                pstmt.setString(2, route.getVilleDepart());
                pstmt.setString(3, route.getVilleEscale());
                pstmt.setString(4, route.getVilleArrivee());
                pstmt.executeUpdate();
            }

            // Valider la transaction
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion des erreurs : rollback si une erreur se produit
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            // Fermer la connexion si elle a été ouverte
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    // Méthode unifiée pour mettre à jour des enregistrements
    public void updateRecords(Compagnie compagnie, Automobile automobile, Route route) {
        String compagnieQuery = "UPDATE Compagnie SET Sigle_Compagnie = ?, Nom_Compagnie = ? WHERE Id_Compagnie = ?";
        String automobileQuery = "UPDATE Automobile SET Num_Plaque = ?, Marque_Automobile = ? WHERE IdAutomobile = ?";
        String routeQuery = "UPDATE Route SET NomRoute = ?, VilleDépart = ?, VilleEscale = ?, Ville_Arrivé = ? WHERE IdRoute = ?";

        Connection conn = null; // Déclarer conn ici

        try {
            conn = DatabaseConnection.getConnection(); // Initialiser conn ici
            if (conn == null) {
                throw new SQLException("Échec lors de la connexion ");
            }
            conn.setAutoCommit(false); // Désactiver l'auto-commit

            // Mettre à jour Compagnie
            try (PreparedStatement pstmt = conn.prepareStatement(compagnieQuery)) {
                pstmt.setString(1, compagnie.getSigleCompagnie());
                pstmt.setString(2, compagnie.getNomCompagnie());
                pstmt.setInt(3, compagnie.getIdCompagnie());
                pstmt.executeUpdate();
            }

            // Mettre à jour Automobile
            try (PreparedStatement pstmt = conn.prepareStatement(automobileQuery)) {
                pstmt.setString(1, automobile.getNumPlaque());
                pstmt.setString(2, automobile.getMarqueAutomobile());
                pstmt.setInt(3, automobile.getIdAutomobile());
                pstmt.executeUpdate();
            }

            // Mettre à jour Route
            try (PreparedStatement pstmt = conn.prepareStatement(routeQuery)) {
                pstmt.setString(1, route.getNomRoute());
                pstmt.setString(2, route.getVilleDepart());
                pstmt.setString(3, route.getVilleEscale());
                pstmt.setString(4, route.getVilleArrivee());
                pstmt.setInt(5, route.getIdRoute());
                pstmt.executeUpdate();
            }

            // Valider la transaction
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion des erreurs : rollback si une erreur se produit
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            // Fermer la connexion si elle a été ouverte
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    public List<Object> readAllDetails() {
         List<Object> detailsList = new ArrayList<>();
    // Requête pour la table Compagnie
    String sqlCompagnie = "SELECT * FROM Compagnie";
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rsCompagnie = stmt.executeQuery(sqlCompagnie)) {

        while (rsCompagnie.next()) {
            Compagnie compagnie = new Compagnie(
                rsCompagnie.getString("Sigle_Compagnie"),
                rsCompagnie.getString("Nom_Compagnie"),
                rsCompagnie.getInt("Id_Compagnie")
            );
            detailsList.add(compagnie);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des compagnies : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    // Requête pour la table Automobile
    String sqlAutomobile = "SELECT * FROM Automobile";
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rsAutomobile = stmt.executeQuery(sqlAutomobile)) {

        while (rsAutomobile.next()) {
            Automobile automobile = new Automobile(
                rsAutomobile.getString("Num_Plaque"),
                rsAutomobile.getString("Marque_Automobile"),
                    rsAutomobile.getInt("IdAutomobile")
            );
            detailsList.add(automobile);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des automobiles : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    // Requête pour la table Route
    String sqlRoute = "SELECT * FROM Route";
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rsRoute = stmt.executeQuery(sqlRoute)) {

        while (rsRoute.next()) {
            Route route = new Route(
                rsRoute.getString("NomRoute"),
                rsRoute.getString("VilleDépart"),
                rsRoute.getString("VilleEscale"),
                rsRoute.getString("Ville_Arrivé"),
                rsRoute.getInt("IdRoute")
            );
            detailsList.add(route);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des routes : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    return detailsList;
    }
    // Méthode pour récupérer toutes les compagnies
public List<Compagnie> readAllCompagnies() {
    List<Compagnie> compagnies = new ArrayList<>();
    String query = "SELECT * FROM Compagnie";
    Connection conn = null;

    try {
        conn = DatabaseConnection.getConnection();
        if (conn == null) {
            throw new SQLException("Échec lors de la connexion ");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Compagnie compagnie = new Compagnie(
                    rs.getString("Sigle_Compagnie"),
                    rs.getString("Nom_Compagnie"),
                        rs.getInt("Id_Compagnie")
                );
                compagnies.add(compagnie);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des compagnies : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Fermer la connexion si elle a été ouverte
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
    return compagnies;
}

// Méthode pour récupérer toutes les automobiles
public List<Automobile> readAllAutomobiles() {
    List<Automobile> automobiles = new ArrayList<>();
    String query = "SELECT * FROM Automobile";
    Connection conn = null;

    try {
        conn = DatabaseConnection.getConnection();
        if (conn == null) {
            throw new SQLException("Échec lors de la connexion ");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Automobile automobile = new Automobile(
                    rs.getString("Num_Plaque"),
                    rs.getString("Marque_Automobile"),
                    rs.getInt("IdAutomobile")
                );
                automobiles.add(automobile);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des automobiles : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Fermer la connexion si elle a été ouverte
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
    return automobiles;
}

// Méthode pour récupérer toutes les routes
public List<Route> readAllRoutes() {
    List<Route> routes = new ArrayList<>();
    String query = "SELECT * FROM Route";
    Connection conn = null;

    try {
        conn = DatabaseConnection.getConnection();
        if (conn == null) {
            throw new SQLException("Échec lors de la connexion ");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Route route = new Route(
                    rs.getString("NomRoute"),
                    rs.getString("VilleDépart"),
                    rs.getString("VilleEscale"),
                    rs.getString("Ville_Arrivé"),
                    rs.getInt("IdRoute")
                );
                routes.add(route);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des routes : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Fermer la connexion si elle a été ouverte
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
    return routes;
}
}