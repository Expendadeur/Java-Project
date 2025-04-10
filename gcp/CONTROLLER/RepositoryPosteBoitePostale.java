/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcp.CONTROLLER;
import gcp.Database.DatabaseConnection;
import gcp.MODELES.Poste;
import gcp.MODELES.BoitePostale;
import gcp.MODELES.PosteBoiteDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class RepositoryPosteBoitePostale {
    // Méthode pour créer un poste et une boîte postale
    public void createPosteAndBoitePostale(Poste poste, BoitePostale boitePostale) {
    String insertPoste = "INSERT INTO Poste (Nom_poste, Régime, Pays, Ville) VALUES (?, ?, ?, ?)";
    String insertBoite = "INSERT INTO BoitePostale (IdPoste, Num_BP, Type_BP, Etat_BP) VALUES (?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection()) {
        // Démarrer la transaction
        conn.setAutoCommit(false); // Désactiver l'engagement automatique

        try (PreparedStatement pstmtPoste = conn.prepareStatement(insertPoste, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstmtBoite = conn.prepareStatement(insertBoite)) {

            // Insérer le poste
            pstmtPoste.setString(1, poste.getNomPoste());
            pstmtPoste.setString(2, poste.getRegime());
            pstmtPoste.setString(3, poste.getPays());
            pstmtPoste.setString(4, poste.getVille());
            int affectedRowsPoste = pstmtPoste.executeUpdate();

            // Vérifier si l'insertion du poste a réussi
            if (affectedRowsPoste == 0) {
                throw new SQLException("Échec de l'insertion du poste, aucune ligne affectée.");
            }

            // Récupérer l'ID généré du poste
            try (ResultSet generatedKeys = pstmtPoste.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int posteId = generatedKeys.getInt(1);

                    // Insérer la boîte postale avec l'ID du poste
                    pstmtBoite.setInt(1, posteId);
                    pstmtBoite.setString(2, boitePostale.getNumBP());
                    pstmtBoite.setString(3, boitePostale.getTypeBP());
                    pstmtBoite.setString(4, boitePostale.getEtatBP());
                    int affectedRowsBoite = pstmtBoite.executeUpdate();

                    // Vérifier si l'insertion de la boîte postale a réussi
                    if (affectedRowsBoite == 0) {
                        throw new SQLException("Échec de l'insertion de la boîte postale, aucune ligne affectée.");
                    }

                    // Si tout est réussi, engager la transaction
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Poste et Boîte Postale ajoutés avec succès !");
                } else {
                    throw new SQLException("Erreur lors de la récupération de l'ID du poste.");
                }
            }
        } catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Réinitialiser le mode d'engagement automatique
            conn.setAutoCommit(true);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la connexion à la base de données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
  public void updatePosteAndBoite(Poste poste, BoitePostale boitePostale) {
    String updatePoste = "UPDATE Poste SET Nom_poste=?, Régime=?, Pays=?, Ville=? WHERE IdPoste=?";
    String updateBoite = "UPDATE BoitePostale SET Num_BP=?, Type_BP=?, Etat_BP=? WHERE Id_BP=?";

    Connection conn = null; // Déclaration en dehors du try
    try {
        conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false); // Démarrer la transaction

        // Préparer les instructions
        try (PreparedStatement pstmtPoste = conn.prepareStatement(updatePoste);
             PreparedStatement pstmtBoite = conn.prepareStatement(updateBoite)) {

            // Mettre à jour le poste
            pstmtPoste.setString(1, poste.getNomPoste());
            pstmtPoste.setString(2, poste.getRegime());
            pstmtPoste.setString(3, poste.getPays());
            pstmtPoste.setString(4, poste.getVille());
            pstmtPoste.setInt(5, poste.getIdPoste());
            pstmtPoste.executeUpdate();

            // Mettre à jour la boîte postale
            pstmtBoite.setString(1, boitePostale.getNumBP());
            pstmtBoite.setString(2, boitePostale.getTypeBP());
            pstmtBoite.setString(3, boitePostale.getEtatBP());
            pstmtBoite.setInt(4, boitePostale.getIdBP());
            pstmtBoite.executeUpdate();
        }

        // Valider la transaction
        conn.commit();
        JOptionPane.showMessageDialog(null, "Mise à jour réussie !");
    } catch (SQLException e) {
        // En cas d'erreur, annuler la transaction
        if (conn != null) {
            try {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Transaction annulée : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'annulation : " + rollbackEx.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
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

    // Méthode pour supprimer un poste et une boîte postale
    public void deletePosteAndBoite(int posteId, int boiteId) {
        String deletePoste = "DELETE FROM Poste WHERE IdPoste = ?";
        String deleteBoite = "DELETE FROM BoitePostale WHERE Id_BP = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtPoste = conn.prepareStatement(deletePoste);
             PreparedStatement pstmtBoite = conn.prepareStatement(deleteBoite)) {

            // Supprimer le poste
            pstmtPoste.setInt(1, posteId);
            pstmtPoste.executeUpdate();

            // Supprimer la boîte postale
            pstmtBoite.setInt(1, boiteId);
            pstmtBoite.executeUpdate();

            JOptionPane.showMessageDialog(null, "Suppression réussie !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode pour lire les données des deux tables avec une jointure
    public List<PosteBoiteDetails> readPosteBoiteDetails() {
        List<PosteBoiteDetails> detailsList = new ArrayList<>();
        String sql = "SELECT p.*, b.* FROM Poste p JOIN BoitePostale b ON p.IdPoste = b.IdPoste";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Poste poste = new Poste(
                        rs.getString("Nom_poste"),
                        rs.getString("Régime"),
                        rs.getString("Pays"),
                        rs.getString("Ville"),
                        rs.getInt("IdPoste")
                );

                BoitePostale boitePostale = new BoitePostale(
                        rs.getString("Num_BP"),
                        rs.getString("Type_BP"),
                        rs.getString("Etat_BP"),
                        rs.getInt("Id_BP")
                );

                detailsList.add(new PosteBoiteDetails(poste, boitePostale));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des détails : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return detailsList;
    }
}
