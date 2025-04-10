/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.CONTROLLER;

import gcp.Database.DatabaseConnection;
import gcp.MODELES.Courrier;
import gcp.MODELES.CourrierDetails;
import gcp.MODELES.Deposant;
import gcp.MODELES.Destinataire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ISSA 2025
 */
public class RepositoryDetailCourier {
public void createCourrierWithDetails(Courrier courrier, Deposant deposant, Destinataire destinataire) {
    String insertCourrier = "INSERT INTO Courrier (Origine_Courrier, Destination_Courrier, Poids_Courrier, Type_Courrier, Date_Envoi, Date_Reçu, Description_Courrier, Montant_Paye, Statut, Id_Agence_Origine, Id_Agence_Destination) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String insertDep = "INSERT INTO Déposant (Id_Courrier, Num_Identité, Adresse, Nom_Déposant, Prénom_Déposant, Tél_Déposant, Sexe) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String insertDest = "INSERT INTO Destinataire (Id_CourrierEnvoye, Prenom, Nom, Telephone, Sexe, Adresse, Num_Identité) VALUES (?, ?, ?, ?, ?, ?, ?)";

    Connection conn = null;
    try {
        conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false); // Démarrer la transaction

        try (PreparedStatement pstmtCourrier = conn.prepareStatement(insertCourrier, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstmtDep = conn.prepareStatement(insertDep);
             PreparedStatement pstmtDest = conn.prepareStatement(insertDest)) {

            // Insérer le courrier
            pstmtCourrier.setString(1, courrier.getOrigineCourrier());
            pstmtCourrier.setString(2, courrier.getDestinationCourrier());
            pstmtCourrier.setDouble(3, courrier.getPoidsCourrier());
            pstmtCourrier.setString(4, courrier.getTypeCourrier());
            pstmtCourrier.setDate(5, new java.sql.Date(courrier.getDateEnvoi().getTime()));
            pstmtCourrier.setDate(6, new java.sql.Date(courrier.getDateRecu().getTime()));
            pstmtCourrier.setString(7, courrier.getDescriptionCourrier());
            pstmtCourrier.setDouble(8, courrier.getMontantPaye());
            pstmtCourrier.setString(9, courrier.getStatut());
            pstmtCourrier.setInt(10, courrier.getIdAgenceOrigine()); // Ajout de l'ID d'agence d'origine
            pstmtCourrier.setInt(11, courrier.getIdAgenceDestination()); // Ajout de l'ID d'agence de destination
            pstmtCourrier.executeUpdate();

            // Récupérer l'ID généré du courrier
            try (ResultSet generatedKeys = pstmtCourrier.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int courrierId = generatedKeys.getInt(1);
                    
                    // Insérer le déposant avec l'ID du courrier
                    pstmtDep.setInt(1, courrierId);
                    pstmtDep.setString(2, deposant.getNumIdentite());
                    pstmtDep.setString(3, deposant.getAdresse());
                    pstmtDep.setString(4, deposant.getNomDeposant());
                    pstmtDep.setString(5, deposant.getPrenomDeposant());
                    pstmtDep.setString(6, deposant.getTelDeposant());
                    pstmtDep.setString(7, deposant.getSexe());
                    pstmtDep.executeUpdate();

                    // Insérer le destinataire avec l'ID du courrier
                    pstmtDest.setInt(1, courrierId);
                    pstmtDest.setString(2, destinataire.getPrenom());
                    pstmtDest.setString(3, destinataire.getNom());
                    pstmtDest.setString(4, destinataire.getTelephone());
                    pstmtDest.setString(5, destinataire.getSexe());
                    pstmtDest.setString(6, destinataire.getAdresse());
                    pstmtDest.setString(7, destinataire.getNumIdentite());
                    pstmtDest.executeUpdate();

                    // Valider la transaction
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Courrier, Déposant et Destinataire ajoutés avec succès !");
                } else {
                    JOptionPane.showMessageDialog(null, "Erreur lors de la récupération de l'ID du courrier.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    conn.rollback(); // Annuler la transaction
                }
            }
        } catch (SQLException e) {
            conn.rollback(); // Annuler la transaction en cas d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur de connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true); // Réinitialiser le mode auto-commit
                conn.close(); // Fermer la connexion
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture de la connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

public int getIdAgenceByName(String nomAgence) {
    int idAgence = -1; // Valeur par défaut si non trouvé
    String query = "SELECT Id_Agence FROM Agence WHERE Nom_Agence = ?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, nomAgence);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            idAgence = rs.getInt("Id_Agence");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return idAgence; // Retourne -1 si non trouvé
}

    // Méthode pour lire tous les courriers
    public List<Courrier> readCourriers() {
        List<Courrier> courriers = new ArrayList<>();
        String sql = "SELECT * FROM Courrier";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Courrier courrier = new Courrier(
                        rs.getInt("Id_Courrier"),
                        rs.getString("Origine_Courrier"),
                        rs.getString("Destination_Courrier"),
                        rs.getInt("Poids_Courrier"),
                        rs.getString("Type_Courrier"),
                        rs.getDate("Date_Envoi"),
                        rs.getDate("Date_Reçu"),
                        rs.getString("Description_Courrier"),
                        rs.getDouble("Montant_Paye"),
                        rs.getString("Statut")
                );
                courriers.add(courrier);
            }
            JOptionPane.showMessageDialog(null, "Courriers récupérés avec succès !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des courriers : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return courriers;
    }

    // Méthode pour lire tous les déposants
    public List<Deposant> readDeposants() {
        List<Deposant> depositants = new ArrayList<>();
        String sql = "SELECT * FROM Déposant";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Deposant deposant = new Deposant(
                        rs.getInt("Id_Déposant"),
                        rs.getInt("Id_Déposant"),
                        rs.getString("Num_Identité"),
                        rs.getString("Adresse"),
                        rs.getString("Nom_Déposant"),
                        rs.getString("Prénom_Déposant"),
                        rs.getString("Tél_Déposant"),
                        rs.getString("Sexe")
                );
                depositants.add(deposant);
            }
            JOptionPane.showMessageDialog(null, "Déposants récupérés avec succès !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des déposants : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return depositants;
    }

    // Méthode pour lire tous les destinataires
    public List<Destinataire> readDestinataires() {
        List<Destinataire> destinataires = new ArrayList<>();
        String sql = "SELECT * FROM Destinataire";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Destinataire destinataire = new Destinataire(
                        rs.getInt("Id_Destinataire"),
                        rs.getInt("Id_Destinataire"),
                        rs.getString("Prénom"),
                        rs.getString("Nom"),
                        rs.getString("Téléphone"),
                        rs.getString("Sexe"),
                        rs.getString("Adresse"),
                        rs.getString("Num_Identité")
                );
                destinataires.add(destinataire);
            }
            JOptionPane.showMessageDialog(null, "Destinataires récupérés avec succès !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des destinataires : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return destinataires;
    }

 public void updateCourrierWithDetails(Courrier courrier, Deposant deposant, Destinataire destinataire) {
    String updateCourrier = "UPDATE Courrier SET Origine_Courrier = ?, Destination_Courrier = ?, Poids_Courrier = ?, Type_Courrier = ?, Date_Envoi = ?, Date_Reçu = ?, Description_Courrier = ?, Montant_Paye = ? WHERE Id_Courrier = ?";
    String updateDep = "UPDATE Déposant SET Num_Identité = ?, Adresse = ?, Nom_Déposant = ?, Prénom_Déposant = ?, Tél_Déposant = ?, Sexe = ? WHERE Id_Déposant = ?";
    String updateDest = "UPDATE Destinataire SET Prénom = ?, Nom = ?, Téléphone = ?, Sexe = ?, Adresse = ?, Num_Identité = ? WHERE Id_Destinataire = ?";

    Connection conn = null; // Déclaration en dehors du try
    try {
        conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false); // Démarrer la transaction

        try (PreparedStatement pstmtCourrier = conn.prepareStatement(updateCourrier);
             PreparedStatement pstmtDep = conn.prepareStatement(updateDep);
             PreparedStatement pstmtDest = conn.prepareStatement(updateDest)) {

            // Mettre à jour le courrier
            pstmtCourrier.setString(1, courrier.getOrigineCourrier());
            pstmtCourrier.setString(2, courrier.getDestinationCourrier());
            pstmtCourrier.setInt(3, courrier.getPoidsCourrier());
            pstmtCourrier.setString(4, courrier.getTypeCourrier());
            pstmtCourrier.setDate(5, (java.sql.Date) courrier.getDateEnvoi()); // Assurez-vous que ce soit un LocalDate
            pstmtCourrier.setDate(6, (java.sql.Date) courrier.getDateRecu());
            pstmtCourrier.setString(7, courrier.getDescriptionCourrier());
            pstmtCourrier.setDouble(8, courrier.getMontantPaye());
            pstmtCourrier.setInt(9, courrier.getIdCourrier()); // Assurez-vous d'utiliser l'ID
            pstmtCourrier.executeUpdate();

            // Mettre à jour le déposant
            pstmtDep.setString(1, deposant.getNumIdentite());
            pstmtDep.setString(2, deposant.getAdresse());
            pstmtDep.setString(3, deposant.getNomDeposant());
            pstmtDep.setString(4, deposant.getPrenomDeposant());
            pstmtDep.setString(5, deposant.getTelDeposant());
            pstmtDep.setString(6, deposant.getSexe());
            pstmtDep.setInt(7, deposant.getIdDeposant());
            pstmtDep.executeUpdate();

            // Mettre à jour le destinataire
            pstmtDest.setString(1, destinataire.getPrenom());
            pstmtDest.setString(2, destinataire.getNom());
            pstmtDest.setString(3, destinataire.getTelephone());
            pstmtDest.setString(4, destinataire.getSexe());
            pstmtDest.setString(5, destinataire.getAdresse());
            pstmtDest.setString(6, destinataire.getNumIdentite());
            pstmtDest.setInt(7, destinataire.getIdDestinataire());
            pstmtDest.executeUpdate();

            // Valider la transaction
            conn.commit();
            JOptionPane.showMessageDialog(null, "Mise à jour réussie !");
        } catch (SQLException e) {
            conn.rollback(); // Annuler la transaction en cas d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur de connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true); // Réinitialiser le mode auto-commit
                conn.close(); // Fermer la connexion
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture de la connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

    public void deleteCourrierWithDetails(int courrierId, int deposantId, int destinataireId) {
    String deleteCourrier = "DELETE FROM Courrier WHERE Id_Courrier = ?";
    String deleteDep = "DELETE FROM Déposant WHERE Id_Déposant = ?";
    String deleteDest = "DELETE FROM Destinataire WHERE Id_Destinataire = ?";

    Connection conn = null; // Déclaration en dehors du try
    try {
        conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false); // Démarrer la transaction

        try (PreparedStatement pstmtCourrier = conn.prepareStatement(deleteCourrier);
             PreparedStatement pstmtDep = conn.prepareStatement(deleteDep);
             PreparedStatement pstmtDest = conn.prepareStatement(deleteDest)) {

            // Supprimer le courrier
            pstmtCourrier.setInt(1, courrierId);
            pstmtCourrier.executeUpdate();

            // Supprimer le déposant
            pstmtDep.setInt(1, deposantId);
            pstmtDep.executeUpdate();

            // Supprimer le destinataire
            pstmtDest.setInt(1, destinataireId);
            pstmtDest.executeUpdate();

            // Valider la transaction
            conn.commit();
            JOptionPane.showMessageDialog(null, "Suppression réussie !");
        } catch (SQLException e) {
            conn.rollback(); // Annuler la transaction en cas d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur de connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true); // Réinitialiser le mode auto-commit
                conn.close(); // Fermer la connexion
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture de la connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

  // Méthode pour lire les courriers avec détails
    public List<CourrierDetails> readCourrierDetails() {
        List<CourrierDetails> detailsList = new ArrayList<>();
        String sqls = "SELECT c.Id_Courrier, c.Origine_Courrier, c.Destination_Courrier, c.Poids_Courrier,c.Type_Courrier, c.Date_Envoi, c.Date_Reçu, c.Description_Courrier, c.Montant_Paye,c.Statut,d.Id_Déposant, d.Num_Identité, d.Adresse, d.Nom_Déposant, d.Prénom_Déposant, d.Tél_Déposant, d.Sexe,dest.Id_Destinataire, dest.Prenom AS Prénom_Dest, dest.Nom AS Nom_Dest,dest.Telephone, dest.Sexe AS Sexe_Dest, dest.Adresse AS Adresse_Dest,dest.Num_Identité FROM Courrier c JOIN Déposant d ON c.Id_Courrier = d.Id_Courrier JOIN Destinataire dest ON c.Id_Courrier = dest.Id_CourrierEnvoye ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqls)) {
            while (rs.next()) {
                Courrier courrier = new Courrier(
                        rs.getInt("Id_Courrier"),
                        rs.getString("Origine_Courrier"),
                        rs.getString("Destination_Courrier"),
                        rs.getInt("Poids_Courrier"),
                        rs.getString("Type_Courrier"),
                        rs.getDate("Date_Envoi"),
                        rs.getDate("Date_Reçu"),
                        rs.getString("Description_Courrier"),
                        rs.getDouble("Montant_Paye"),
                        rs.getString("Statut")
                );

                Deposant deposant = new Deposant(
                        rs.getInt("Id_Déposant"),
                        rs.getString("Num_Identité"),
                        rs.getString("Adresse"),
                        rs.getString("Nom_Déposant"),
                        rs.getString("Prénom_Déposant"),
                        rs.getString("Tél_Déposant"),
                        rs.getString("Sexe")
                );

                Destinataire destinataire = new Destinataire(
                        rs.getString("Nom_Dest"),
                        rs.getString("Prénom_Dest"),
                        rs.getString("Telephone"),
                        rs.getString("Sexe_Dest"),
                        rs.getString("Num_Identité"),
                        rs.getString("Adresse_Dest"),
                        rs.getInt("Id_Destinataire")
                        
                );
                detailsList.add(new CourrierDetails(courrier, deposant, destinataire));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des détails : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return detailsList;
    }
    
  public List<CourrierDetails> readCourriersRecus() {
    List<CourrierDetails> detailsList = new ArrayList<>();
    String sql = "SELECT c.Id_Courrier, c.Origine_Courrier, c.Destination_Courrier, c.Poids_Courrier, " +
                 "c.Type_Courrier, c.Date_Reçu, c.Montant_Paye, c.Statut, " +
                 "d.Nom_Déposant, d.Prénom_Déposant, " +
                 "dest.Prenom AS Prénom_Dest, dest.Nom AS Nom_Dest " +
                 "FROM Courrier c " +
                 "JOIN Déposant d ON c.Id_Courrier = d.Id_Courrier " +
                 "JOIN Destinataire dest ON c.Id_Courrier = dest.Id_CourrierEnvoye " +
                 "WHERE c.Statut = 'Distribué'"; // Filtre pour les courriers reçus

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Courrier courrier = new Courrier(
                    rs.getInt("Id_Courrier"),
                    rs.getString("Origine_Courrier"),
                    rs.getString("Destination_Courrier"),
                    rs.getInt("Poids_Courrier"),
                    rs.getString("Type_Courrier"),
                    null, // Date Envoi est nulle pour les courriers reçus
                    rs.getDate("Date_Reçu"),
                    null, // Description non nécessaire
                    rs.getDouble("Montant_Paye"),
                    rs.getString("Statut")
            );

            Deposant deposant = new Deposant(
                    0, // ID non nécessaire
                    "", // Num Identité non nécessaire
                    "", // Adresse non nécessaire
                    rs.getString("Nom_Déposant"),
                    rs.getString("Prénom_Déposant"),
                    "", // Téléphone non nécessaire
                    ""  // Sexe non nécessaire
            );

            Destinataire destinataire = new Destinataire(
                    0, // ID non nécessaire
                    rs.getString("Prénom_Dest"),
                    rs.getString("Nom_Dest"),
                    "", // Téléphone non nécessaire
                    "", // Sexe non nécessaire
                    "", // Adresse non nécessaire
                    ""  // Num Identité non nécessaire
            );

            detailsList.add(new CourrierDetails(courrier, deposant, destinataire));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des courriers reçus : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    return detailsList;
}

public List<CourrierDetails> readCourriersEnvoyes() {
    List<CourrierDetails> detailsList = new ArrayList<>();
    String sql = "SELECT c.Id_Courrier, c.Origine_Courrier, c.Destination_Courrier, c.Poids_Courrier, " +
                 "c.Type_Courrier, c.Date_Envoi, c.Montant_Paye, c.Statut, " +
                 "d.Nom_Déposant, d.Prénom_Déposant, " +
                 "dest.Prenom AS Prénom_Dest, dest.Nom AS Nom_Dest " +
                 "FROM Courrier c " +
                 "JOIN Déposant d ON c.Id_Courrier = d.Id_Courrier " +
                 "JOIN Destinataire dest ON c.Id_Courrier = dest.Id_CourrierEnvoye " +
                 "WHERE c.Statut = 'Envoyé'"; // Filtre pour les courriers envoyés

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Courrier courrier = new Courrier(
                    rs.getInt("Id_Courrier"),
                    rs.getString("Origine_Courrier"),
                    rs.getString("Destination_Courrier"),
                    rs.getInt("Poids_Courrier"),
                    rs.getString("Type_Courrier"),
                    rs.getDate("Date_Envoi"),
                    null, // Date Reçu est nulle pour les courriers envoyés
                    null, // Description non nécessaire
                    rs.getDouble("Montant_Paye"),
                    rs.getString("Statut")
            );

            Deposant deposant = new Deposant(
                    0, // ID non nécessaire
                    "", // Num Identité non nécessaire
                    "", // Adresse non nécessaire
                    rs.getString("Nom_Déposant"),
                    rs.getString("Prénom_Déposant"),
                    "", // Téléphone non nécessaire
                    ""  // Sexe non nécessaire
            );

            Destinataire destinataire = new Destinataire(
                    0, // ID non nécessaire
                    rs.getString("Prénom_Dest"),
                    rs.getString("Nom_Dest"),
                    "", // Téléphone non nécessaire
                    "", // Sexe non nécessaire
                    "", // Adresse non nécessaire
                    ""  // Num Identité non nécessaire
            );

            detailsList.add(new CourrierDetails(courrier, deposant, destinataire));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des courriers envoyés : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    return detailsList;

  }  
    
    
}
