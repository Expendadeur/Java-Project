/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryDetailCourier;
import gcp.Database.DatabaseConnection;
import gcp.MODELES.Courrier;
import gcp.MODELES.CourrierDetails;
import gcp.MODELES.Deposant;
import gcp.MODELES.Destinataire;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISSA 2025
 */
public class Courier extends javax.swing.JPanel {
private DefaultTableModel tableModel;
private RepositoryDetailCourier repository;
    private int currentPanelIndex;
    public Courier() {
        initComponents();
        repository=new RepositoryDetailCourier();
        loadPosteNamesIntoComboBox(dest);
        loadPosteNamesIntoComboBox(origine);
        
        loadCourrierDetails();
        IdC.setEditable(false);
        IdC.setVisible(false);
         IdB.setEditable(false);
         IdC.setFocusable(false);
         IdB.setVisible(false);
         IdB.setFocusable(false);
         IdD.setEditable(false);
         IdD.setFocusable(false);
         IdD.setVisible(false);
         montant.setEditable(false);
         montant.setFocusable(false);
         // showPanel1();
    }
    private void showPanel1() {
    jPanel3.setVisible(true);   // Afficher le panneau 1
    jPanel7.setVisible(true);
    jPanel4.setVisible(false);  // Cacher le panneau 2
    jPanel8.setVisible(false);
    jPanel9.setVisible(false);
    jPanel5.setVisible(false);  // Cacher le panneau 3
 
}

private void showPanel2() {
    jPanel3.setVisible(false);  // Cacher le panneau 1
    jPanel7.setVisible(false);
    jPanel4.setVisible(true);
    jPanel8.setVisible(true);// Afficher le panneau 2
    jPanel9.setVisible(false);
    jPanel5.setVisible(false);  // Cacher le panneau 3
}

private void showPanel3() {
    jPanel3.setVisible(false);  // Cacher le panneau 1
    jPanel7.setVisible(false);
    jPanel4.setVisible(false);  // Cacher le panneau 2
    jPanel8.setVisible(false);
    jPanel5.setVisible(true);   // Afficher le panneau 3
    jPanel9.setVisible(true);
}
    
private void showNextPanel() {
    if (jPanel3.isVisible()) {
        showPanel2(); // Si le panneau 1 est visible, afficher le panneau 2
    } else if (jPanel4.isVisible()) {
        showPanel3(); // Si le panneau 2 est visible, afficher le panneau 3
    }
    // Si le panneau 3 est visible, vous pouvez choisir de revenir au premier ou faire rien
}

private void showPreviousPanel() {
    if (jPanel3.isVisible()) {
        showPanel2(); // Si le panneau 3 est visible, afficher le panneau 2
    } else if (jPanel4.isVisible()) {
        showPanel1(); // Si le panneau 2 est visible, afficher le panneau 1
    }
}
    
private void centerPanel(JPanel panel) {
    panel.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour centrer
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER; // Centrer le composant
    gbc.insets = new Insets(10, 10, 10, 10); // Marges

    // Avoir tous les composants centrés
    for (Component comp : panel.getComponents()) {
        panel.add(comp, gbc);
        gbc.gridy++; // Passer à la ligne suivante pour le prochain composant
    }
}
// Méthode pour charger le tarif en fonction du type de courrier sélectionné
public void loadTarifForCourierType(JComboBox<String> typeCourierComboBox, JTextField tarifField) {
    String selectedType = (String) typeCourierComboBox.getSelectedItem();
    String query = "SELECT Tarif FROM Tarification WHERE Type_Courrier = ?"; // Requête SQL

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, selectedType); // Remplacez le paramètre par le type de courrier sélectionné
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            double prixFixe = rs.getDouble("Tarif");
            tarifField.setText(Double.toString(prixFixe)); // Afficher le tarif dans le JTextField
        } else {
            tarifField.setText("0.0"); // Afficher 0 si aucun tarif n'est trouvé
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération du tarif : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    
       }
      public void loadPosteNamesIntoComboBox(JComboBox<String> destination) {
        String query = "SELECT Nom_poste FROM Poste"; // Votre requête SQL pour récupérer les noms de poste
        ArrayList<String> posteNames = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Parcourir les résultats et ajouter les noms de poste à la liste
            while (rs.next()) {
                posteNames.add(rs.getString("Nom_poste"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des noms de poste : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        // Ajouter les noms de poste au JComboBox dest
        destination.removeAllItems(); // Vider le JComboBox avant d'ajouter les nouveaux éléments
        for (String name : posteNames) {
            destination.addItem(name);
        }
    }
private void loadCourrierDetails() {
    // Vider le modèle de tableau avant de le remplir
    DefaultTableModel tableModel = (DefaultTableModel) tablecouriers.getModel();
    tableModel.setRowCount(0); // Vide le tableau

    // Récupérer les détails des courriers
    List<CourrierDetails> detailsList = repository.readCourrierDetails();

    // Remplir le tableau avec les données récupérées
    for (CourrierDetails details : detailsList) {
        Courrier courrier = details.getCourrier();
        Deposant deposant = details.getDeposant();
        Destinataire destinataire = details.getDestinataire();

        Object[] rowData = {
            courrier.getIdCourrier(),
            courrier.getOrigineCourrier(),
            courrier.getDestinationCourrier(),
            courrier.getPoidsCourrier(),
            courrier.getTypeCourrier(),
            courrier.getDateEnvoi(),
            courrier.getDateRecu(),
            courrier.getMontantPaye(),
            courrier.getStatut(),
            deposant.getIdDeposant(),
            deposant.getNumIdentite(),
            deposant.getAdresse(),
            deposant.getNomDeposant(),
            deposant.getPrenomDeposant(),
            deposant.getTelDeposant(),
            destinataire.getNom(),
            destinataire.getPrenom(),
            destinataire.getNumIdentite(),
            destinataire.getIdDestinataire()
            
        };
        tableModel.addRow(rowData); // Ajoute la nouvelle ligne au tableau
    }

    //JOptionPane.showMessageDialog(this, "Détails chargés avec succès !");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        poids = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        montant = new javax.swing.JTextField();
        dest = new javax.swing.JComboBox<>();
        origine = new javax.swing.JComboBox<>();
        type = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        dateEnvoie = new com.toedter.calendar.JDateChooser();
        DateRecu = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        sexedeposant = new javax.swing.JComboBox<>();
        nomdeposant = new javax.swing.JTextField();
        prenomdeposant = new javax.swing.JTextField();
        cnideposant = new javax.swing.JTextField();
        teldeposant = new javax.swing.JTextField();
        adressedeposant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        nomrecepteur = new javax.swing.JTextField();
        prenomrecepteur = new javax.swing.JTextField();
        sexerecepteur = new javax.swing.JComboBox<>();
        cnirecepteur = new javax.swing.JTextField();
        Telrecepteur = new javax.swing.JTextField();
        adresserecepteur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablecouriers = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        IdC = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        IdD = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        IdB = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(122, 112, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(1344, 50));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRAITEMENT DES COURIERS POSTAUX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(499, 499, 499)
                .addComponent(jLabel1)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(122, 112, 140));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 0, 204)));

        dest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        origine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Courrier Ordinaire", "Courrier Recommandé" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Poids du Courier");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Origine du Courier");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("Type");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("Destination Courier");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Description");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setText("Date Recu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setText("Montant Payé");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel24.setText("Date Envoie");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel24))
                        .addGap(49, 49, 49)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poids, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(origine, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateEnvoie, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateRecu, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poids, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(origine, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel24)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(DateRecu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateEnvoie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        sexedeposant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculin", "Feminin" }));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel12.setText("Nom");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel13.setText("Prenom");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel14.setText("Sexe");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel15.setText("CNI");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel16.setText("Tél");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel17.setText("Adresse");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adressedeposant)
                    .addComponent(sexedeposant, 0, 234, Short.MAX_VALUE)
                    .addComponent(nomdeposant)
                    .addComponent(prenomdeposant)
                    .addComponent(cnideposant)
                    .addComponent(teldeposant))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomdeposant, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomdeposant, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexedeposant, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnideposant, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teldeposant, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressedeposant, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        sexerecepteur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculin", "Feminin" }));

        adresserecepteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adresserecepteurActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel18.setText("Nom");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel19.setText("Prenom");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel20.setText("Sexe");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel21.setText("CNI");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel22.setText("Tél");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel23.setText("Adresse");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prenomrecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomrecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexerecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnirecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Telrecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adresserecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomrecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(prenomrecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexerecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cnirecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(Telrecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(adresserecepteur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 2, 3, 2, new java.awt.Color(0, 0, 0)), "Commande"));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setText("Annuler");

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 102, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Supprimer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablecouriers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Origine", "Destination", "Poids", "Type", "Date Envoie", "Date Recu", "Montant", "Statut", "Identifiant Deposant", "CNI Deposant", "Adresse Deposant", "Nom", "Prenom", "Telephone", "Nom Destinataire", "Prenom Destinataire", "CNI Destinataire", "Id Destinataire"
            }
        ));
        tablecouriers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecouriersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablecouriers);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Caracteristique du Courier");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IdC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdC, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 51), 2));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel10.setText("Expediteur du Courrier ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(IdD, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(IdD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel11.setText("Beneficiare Du Courrier");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(IdB, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdB, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addGap(92, 92, 92))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void adresserecepteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adresserecepteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adresserecepteurActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Récupération des champs
    String descript = description.getText().trim();
    String destination = (String) dest.getSelectedItem();
    String Orgine = (String) origine.getSelectedItem();
    Date DateEnvoie = dateEnvoie.getDate();
    Date dateRecu = DateRecu.getDate();
    String Type = (String) type.getSelectedItem();
    
      // Récupération des ID des agences
    int idAgenceOrigine = repository.getIdAgenceByName(Orgine);
    int idAgenceDestination = repository.getIdAgenceByName(destination);
    
    // Déposant
    String nomDeposant = nomdeposant.getText().trim();
    String prenomDeposant = prenomdeposant.getText().trim();
    String sexe = (String) sexedeposant.getSelectedItem();
    String CNI = cnideposant.getText().trim();
    String phone = teldeposant.getText().trim();
    String adresse = adressedeposant.getText().trim();
    
    // Bénéficiaire
    String nom = nomrecepteur.getText().trim();
    String prenom = prenomrecepteur.getText().trim();
    String sexere = (String) sexerecepteur.getSelectedItem();
    String CNIRE = cnirecepteur.getText().trim();
    String tele = Telrecepteur.getText().trim();
    String adresseR = adresserecepteur.getText().trim();

    // Validation des champs obligatoires
    if (descript.isEmpty() || nomDeposant.isEmpty() || prenomDeposant.isEmpty() ||
        nom.isEmpty() || prenom.isEmpty() || CNI.isEmpty() || CNIRE.isEmpty()) {
        JOptionPane.showMessageDialog(Courier.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Validation des champs numériques
    int Poids;
    double Montant;
    
    try {
        Poids = Integer.parseInt(poids.getText().trim());
        // Vérification si le poids dépasse 2
        if (Poids > 2) {
            JOptionPane.showMessageDialog(Courier.this, "Le poids ne doit pas dépasser 2.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(Courier.this, "Veuillez entrer un poids valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Montant = Double.parseDouble(montant.getText().trim());
    } catch (NumberFormatException e) { 
        JOptionPane.showMessageDialog(Courier.this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Créer les objets Courrier, Déposant et Destinataire
    Courrier courier = new Courrier(Orgine, destination, Poids, Type, DateEnvoie, dateRecu, descript, Montant, "En cours de traitement",idAgenceOrigine,idAgenceDestination);
    Deposant deposant = new Deposant(CNI, adresse, nomDeposant, prenomDeposant, phone, sexe);
    Destinataire desti = new Destinataire(prenom, nom, tele, sexere, adresseR, CNIRE);

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        Courier.this, 
        "Êtes-vous sûr de vouloir ajouter ce courrier et ses détails ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );

    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter le courrier et ses détails
        repository.createCourrierWithDetails(courier, deposant, desti);
        // Charger les détails dans le JTable après l'ajout
        loadCourrierDetails();
        initialiser();
    } else {
        JOptionPane.showMessageDialog(Courier.this, "Ajout annulé.");
    }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
           // Récupération des champs
    String descript = description.getText().trim();
    String destination = (String) dest.getSelectedItem();
    String Orgine = (String) origine.getSelectedItem();
    Date DateEnvoie = dateEnvoie.getDate();
    Date dateRecu = DateRecu.getDate();
    String Type = (String) type.getSelectedItem();
    int idC=Integer.parseInt(IdC.getText());
    
      // Récupération des ID des agences
    int idAgenceOrigine = repository.getIdAgenceByName(Orgine);
    int idAgenceDestination = repository.getIdAgenceByName(destination);
    
    // Déposant
    String nomDeposant = nomdeposant.getText().trim();
    String prenomDeposant = prenomdeposant.getText().trim();
    String sexe = (String) sexedeposant.getSelectedItem();
    String CNI = cnideposant.getText().trim();
    String phone = teldeposant.getText().trim();
    String adresse = adressedeposant.getText().trim();
    int idD=Integer.parseInt(IdD.getText());
    // Bénéficiaire
    String nom = nomrecepteur.getText().trim();
    String prenom = prenomrecepteur.getText().trim();
    String sexere = (String) sexerecepteur.getSelectedItem();
    String CNIRE = cnirecepteur.getText().trim();
    String tele = Telrecepteur.getText().trim();
    String adresseR = adresserecepteur.getText().trim();
    int idB=Integer.parseInt(IdB.getText());
    // Validation des champs obligatoires
    if (descript.isEmpty() || nomDeposant.isEmpty() || prenomDeposant.isEmpty() ||
        nom.isEmpty() || prenom.isEmpty() || CNI.isEmpty() || CNIRE.isEmpty()) {
        JOptionPane.showMessageDialog(Courier.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validation des champs numériques
    int Poids;
    double Montant;
    
    try {
        Poids = Integer.parseInt(poids.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(Courier.this, "Veuillez entrer un poids valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Montant = Double.parseDouble(montant.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(Courier.this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Créer les objets Courrier, Déposant et Destinataire
    Courrier courier = new Courrier(Orgine, destination, Poids, Type, DateEnvoie, dateRecu, descript, Montant,"En cours de traitement",idAgenceOrigine,idAgenceDestination);
    Deposant deposant = new Deposant(CNI, adresse, nomDeposant, prenomDeposant, phone, sexe);
    Destinataire desti = new Destinataire(prenom, nom, tele, sexere, adresseR, CNIRE);

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        Courier.this, 
        "Êtes-vous sûr de vouloir de modifier ce poste et leur détail ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );

    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter le poste et la boîte postale
        repository.updateCourrierWithDetails(courier, deposant, desti);
        // Charger les détails dans le JTable après l'ajout
        loadCourrierDetails();
        initialiser();
    } else {
        JOptionPane.showMessageDialog(Courier.this, "modification annulé.");
    }
      
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
       loadTarifForCourierType(type,montant);
    }//GEN-LAST:event_typeActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         int selectedRow = tablecouriers.getSelectedRow();
    if (selectedRow >= 0) {
        try {
            String idString = tablecouriers.getValueAt(selectedRow, 0).toString(); // ID du courrier
            int courrierId = Integer.parseInt(idString);
            String idDepString = tablecouriers.getValueAt(selectedRow, 9).toString(); // ID du déposant
            int deposantId = Integer.parseInt(idDepString);
            String idDestString = tablecouriers.getValueAt(selectedRow, 18).toString(); // ID du destinataire
            int destinataireId = Integer.parseInt(idDestString);

            // Confirmation de la suppression
            int confirmation = JOptionPane.showConfirmDialog(
                this,
                "Êtes-vous sûr de vouloir supprimer ce courrier et ses détails ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmation == JOptionPane.YES_OPTION) {
                repository.deleteCourrierWithDetails(courrierId, deposantId, destinataireId);
                loadCourrierDetails(); // Recharger les détails après la suppression
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des IDs : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner un courrier à supprimer.", "Erreur", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tablecouriersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecouriersMouseClicked
  if (evt.getClickCount() == 1) { // Vérifie un clic simple
        int selectedRow = tablecouriers.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                // Vérifiez si chaque valeur est nulle avant de l'utiliser
                Object idObj = tablecouriers.getValueAt(selectedRow, 0);
                Object idObj1 = tablecouriers.getValueAt(selectedRow, 9);
                Object idObj2 = tablecouriers.getValueAt(selectedRow, 18);   
                if (idObj == null) {
                    JOptionPane.showMessageDialog(null, "ID est vide.");
                    return;
                }
                if (idObj1 == null) {
                    JOptionPane.showMessageDialog(null, "ID est vide.");
                    return;
                }
                if (idObj2 == null) {
                    JOptionPane.showMessageDialog(null, "ID est vide.");
                    return;
                }
                String idString = idObj.toString();
                int id = Integer.parseInt(idString);
                String idString1 = idObj1.toString();
                int id1 = Integer.parseInt(idString1);
                String idString2 = idObj2.toString();
                int id2 = Integer.parseInt(idString2);

                // Récupérer les autres valeurs avec vérification
                String Origine = getValueOrNull(tablecouriers, selectedRow, 1);
                String destination = getValueOrNull(tablecouriers, selectedRow, 2);
                String poidsValue = getValueOrNull(tablecouriers, selectedRow, 3);
                String montantValue = getValueOrNull(tablecouriers, selectedRow, 7);
                String nomDepo = getValueOrNull(tablecouriers, selectedRow, 12);
                String prenomDepo = getValueOrNull(tablecouriers, selectedRow, 13);

                // Remplir les champs de texte
                IdC.setText(Integer.toString(id));
                IdD.setText(Integer.toString(id1));
                IdB.setText(Integer.toString(id2));
                poids.setText(poidsValue);
                montant.setText(montantValue);
                dest.setSelectedItem(destination);
                origine.setSelectedItem(Origine);
                nomdeposant.setText(nomDepo);
                prenomdeposant.setText(prenomDepo);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la conversion de l'ID : " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_tablecouriersMouseClicked
// Helper method to get value or null check
private String getValueOrNull(JTable table, int row, int column) {
    Object value = table.getValueAt(row, column);
    return (value != null) ? value.toString() : ""; // Retourne une chaîne vide si null
}
    
    private void initialiser() {
    // Réinitialiser les champs de texte
    description.setText("");
    poids.setText("");
    montant.setText("");
    
    // Réinitialiser les sélections des combo boxes
    dest.setSelectedIndex(0); // Sélectionne le premier élément
    origine.setSelectedIndex(0);
    type.setSelectedIndex(0);
    sexedeposant.setSelectedIndex(0);
    sexerecepteur.setSelectedIndex(0);
    
    // Réinitialiser les informations du déposant
    nomdeposant.setText("");
    prenomdeposant.setText("");
    cnideposant.setText("");
    teldeposant.setText("");
    adressedeposant.setText("");
    
    // Réinitialiser les informations du bénéficiaire
    nomrecepteur.setText("");
    prenomrecepteur.setText("");
    cnirecepteur.setText("");
    Telrecepteur.setText("");
    adresserecepteur.setText("");

    // Réinitialiser les dates
    dateEnvoie.setDate(null);
    DateRecu.setDate(null);
    description.requestFocus();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateRecu;
    private javax.swing.JTextField IdB;
    private javax.swing.JTextField IdC;
    private javax.swing.JTextField IdD;
    private javax.swing.JTextField Telrecepteur;
    private javax.swing.JTextField adressedeposant;
    private javax.swing.JTextField adresserecepteur;
    private javax.swing.JTextField cnideposant;
    private javax.swing.JTextField cnirecepteur;
    private com.toedter.calendar.JDateChooser dateEnvoie;
    private javax.swing.JTextField description;
    private javax.swing.JComboBox<String> dest;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField montant;
    private javax.swing.JTextField nomdeposant;
    private javax.swing.JTextField nomrecepteur;
    private javax.swing.JComboBox<String> origine;
    private javax.swing.JTextField poids;
    private javax.swing.JTextField prenomdeposant;
    private javax.swing.JTextField prenomrecepteur;
    private javax.swing.JComboBox<String> sexedeposant;
    private javax.swing.JComboBox<String> sexerecepteur;
    private javax.swing.JTable tablecouriers;
    private javax.swing.JTextField teldeposant;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
