/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryRouteVilleCampagnie;
import gcp.Database.DatabaseConnection;
import gcp.MODELES.Automobile;
import gcp.MODELES.Compagnie;
import gcp.MODELES.Route;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISSA 2025
 */
public class DEPECHEINTERNATIONAL extends javax.swing.JPanel {
RepositoryRouteVilleCampagnie repository;
    public DEPECHEINTERNATIONAL() {
        initComponents();
        repository=new RepositoryRouteVilleCampagnie();
        loadPosteNamesIntoComboBox(villedepart);
        loadPosteNamesIntoComboBox(villeescale);
        loadPosteNamesIntoComboBox(villearrive);
        loadData();
        IdRoute.setFocusable(false);
        IdRoute.setVisible(false);
        IdCampagnie.setFocusable(false);
        IdCampagnie.setVisible(false);
        IdAuto.setFocusable(false);
        IdAuto.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        agencetb = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nomroute = new javax.swing.JTextField();
        villedepart = new javax.swing.JComboBox<>();
        villeescale = new javax.swing.JComboBox<>();
        villearrive = new javax.swing.JComboBox<>();
        nomcampagnie = new javax.swing.JTextField();
        sigle = new javax.swing.JTextField();
        marque = new javax.swing.JTextField();
        plaque = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        IdCampagnie = new javax.swing.JTextField();
        IdRoute = new javax.swing.JTextField();
        IdAuto = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(122, 112, 140));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1418, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Formulaire d'Acheminement Des Dépêches Internationales");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel1)
                .addContainerGap(505, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        agencetb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOM CAMPAGNIE", "SIGLE CAMPAGNIE", "IDCAMPAGNIE", "PLAQUE", "MARQUE", "IDAUTOMOBILE", "NOM DE LA ROUTE", "VILLE DEPART", "VILLE ESCALE", "VILLE ARRIVE", "IDROUTE"
            }
        ));
        agencetb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agencetbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(agencetb);

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 746));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nom Route");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Ville de Depart");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Ville Escalé");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Ville Arrivé");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nom de la Compagnie");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Sigle");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Marque Automobile");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Plaque Automobile");

        villedepart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        villeescale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        villearrive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(villeescale, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(villearrive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomroute))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(villedepart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(marque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(sigle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomcampagnie, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plaque))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(nomroute, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomcampagnie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(villedepart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sigle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(villeescale, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(marque, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(villearrive, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(plaque, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 64, 160));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(IdRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207)
                .addComponent(IdCampagnie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IdAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdCampagnie)
                    .addComponent(IdAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nom=nomroute.getText().trim();
        String vildepart=villedepart.getSelectedItem().toString().trim();
        String vilescale=villeescale.getSelectedItem().toString().trim();
        String vilarrive=villearrive.getSelectedItem().toString().trim();
        String nomcamp=nomcampagnie.getText().trim();
        String sigleC=sigle.getText().trim();
        String Marque=marque.getText().trim();
        String Plaque=plaque.getText().trim();
        
        
    // Validation des champs
    if (nom.isEmpty() || nomcamp.isEmpty() || sigleC.isEmpty() || Marque.isEmpty() || Plaque.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création des objets
    Compagnie compagnie = new Compagnie(sigleC,nomcamp);
    Automobile automobile = new Automobile(Plaque, Marque);
    Route route = new Route(nom, vildepart, vilescale, vilarrive);

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        this, 
        "Êtes-vous sûr de vouloir ajouter cette route et ces informations de compagnie ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  
    
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter les enregistrements
        RepositoryRouteVilleCampagnie repositorys = new RepositoryRouteVilleCampagnie();
        repositorys.createRecords(compagnie, automobile, route);
        
        // Optionnel : Charger les données si nécessaire
         loadData(); // Si vous avez une méthode pour recharger les données
        
        // Réinitialiser les champs
        initialiser(); // Si vous avez une méthode pour réinitialiser les champs
        
        JOptionPane.showMessageDialog(this, "Les enregistrements ont été ajoutés avec succès !");
    } else {
        JOptionPane.showMessageDialog(this, "Ajout annulé.");
    }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agencetbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agencetbMouseClicked
         if (evt.getClickCount() == 1) { // Vérifie un clic simple
        int selectedRow = agencetb.getSelectedRow(); // Récupérer la ligne sélectionnée
        if (selectedRow >= 0) {
            // Récupérer les données de la ligne sélectionnée
            int idC = 0; // Initialisation de l'identifiant pour Compagnie
     Object idCValue = agencetb.getValueAt(selectedRow, 2); // Colonne 2 pour l'identifiant de la compagnie

if (idCValue instanceof Number) {
    idC = ((Number) idCValue).intValue(); // Conversion si c'est un nombre
} else if (idCValue instanceof String) {
    idC = Integer.parseInt((String) idCValue); // Conversion si c'est une chaîne
}

int idR = 0; // Initialisation de l'identifiant pour Route
Object idRValue = agencetb.getValueAt(selectedRow, 10); // Colonne 10 pour l'identifiant de la route

if (idRValue instanceof Number) {
    idR = ((Number) idRValue).intValue(); // Conversion si c'est un nombre
} else if (idRValue instanceof String) {
    idR = Integer.parseInt((String) idRValue); // Conversion si c'est une chaîne
}

int idA = 0; // Initialisation de l'identifiant pour Automobile
Object idAValue = agencetb.getValueAt(selectedRow, 5); // Colonne 5 pour l'identifiant de l'automobile

if (idAValue instanceof Number) {
    idA = ((Number) idAValue).intValue(); // Conversion si c'est un nombre
} else if (idAValue instanceof String) {
    idA = Integer.parseInt((String) idAValue); // Conversion si c'est une chaîne
}// Colonne 10 pour l'ID
            String nomCompagnie = (String) agencetb.getValueAt(selectedRow, 0); // Colonne 0 pour le nom de la compagnie
            String sigleCompagnie = (String) agencetb.getValueAt(selectedRow, 1); // Colonne 1 pour le sigle
            String numPlaque = (String) agencetb.getValueAt(selectedRow, 3); // Colonne 3 pour le numéro de plaque
            String marqueAutomobile = (String) agencetb.getValueAt(selectedRow, 4); // Colonne 4 pour la marque
            String nomRoute = (String) agencetb.getValueAt(selectedRow, 6); // Colonne 6 pour le nom de la route
            String villeDepart = (String) agencetb.getValueAt(selectedRow, 7); // Colonne 7 pour la ville de départ
            String villeEscale = (String) agencetb.getValueAt(selectedRow, 8); // Colonne 8 pour la ville d'escale
            String villeArrivee = (String) agencetb.getValueAt(selectedRow, 9); // Colonne 9 pour la ville d'arrivée

            // Mettre à jour les champs de texte
            nomroute.setText(nomRoute);
            nomcampagnie.setText(nomCompagnie);
            sigle.setText(sigleCompagnie);
            marque.setText(marqueAutomobile);
            plaque.setText(numPlaque);
            villedepart.setSelectedItem(villeDepart);
            villeescale.setSelectedItem(villeEscale);
            villearrive.setSelectedItem(villeArrivee);
            IdRoute.setText(String.valueOf(idR));
            IdAuto.setText(String.valueOf(idA));
            IdCampagnie.setText(String.valueOf(idC));
        }
    }
    }//GEN-LAST:event_agencetbMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // Récupérer les valeurs de texte
    String nom = nomroute.getText().trim();
    String vildepart = villedepart.getSelectedItem().toString().trim();
    String vilescale = villeescale.getSelectedItem().toString().trim();
    String vilarrive = villearrive.getSelectedItem().toString().trim();
    String nomcamp = nomcampagnie.getText().trim();
    String sigleC = sigle.getText().trim();
    String Marque = marque.getText().trim();
    String Plaque = plaque.getText().trim();
    
    // Validation des champs
    if (nom.isEmpty() || nomcamp.isEmpty() || sigleC.isEmpty() || Marque.isEmpty() || Plaque.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Vérification des identifiants
    int Idroute = 0, Idauto = 0, Idcamp = 0;
    try {
        Idroute = Integer.parseInt(IdRoute.getText().trim());
        Idauto = Integer.parseInt(IdAuto.getText().trim());
        Idcamp = Integer.parseInt(IdCampagnie.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Veuillez entrer des identifiants valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création des objets
    Compagnie compagnie = new Compagnie(sigleC, nomcamp, Idcamp);
    Automobile automobile = new Automobile(Plaque, Marque, Idauto);
    Route route = new Route(nom, vildepart, vilescale, vilarrive, Idroute);

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        this, 
        "Êtes-vous sûr de vouloir modifier cette route et ces informations de compagnie ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  
    
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter les enregistrements
        RepositoryRouteVilleCampagnie repositorys = new RepositoryRouteVilleCampagnie();
        repositorys.updateRecords(compagnie, automobile, route);
        
        // Optionnel : Charger les données si nécessaire
        loadData(); // Si vous avez une méthode pour recharger les données
        
        // Réinitialiser les champs
        initialiser(); // Si vous avez une méthode pour réinitialiser les champs
        
        JOptionPane.showMessageDialog(this, "Les modifications ont été faites avec succès !");
    } else {
        JOptionPane.showMessageDialog(this, "Modification annulée.");
    }  
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdAuto;
    private javax.swing.JTextField IdCampagnie;
    private javax.swing.JTextField IdRoute;
    private javax.swing.JTable agencetb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marque;
    private javax.swing.JTextField nomcampagnie;
    private javax.swing.JTextField nomroute;
    private javax.swing.JTextField plaque;
    private javax.swing.JTextField sigle;
    private javax.swing.JComboBox<String> villearrive;
    private javax.swing.JComboBox<String> villedepart;
    private javax.swing.JComboBox<String> villeescale;
    // End of variables declaration//GEN-END:variables

    private void initialiser() {
    // Réinitialiser les champs de texte
    nomroute.setText("");
    nomcampagnie.setText("");
    sigle.setText("");
    marque.setText("");
    plaque.setText("");
    
    // Réinitialiser les listes déroulantes
    villedepart.setSelectedIndex(0); // Remettre à la première option
    villeescale.setSelectedIndex(0); // Remettre à la première option
    villearrive.setSelectedIndex(0); // Remettre à la première option
    }
    
    
     public void loadPosteNamesIntoComboBox(JComboBox<String> destination) {
        String query = "SELECT nomville FROM VilleConfigure"; // Votre requête SQL pour récupérer les noms de poste
        ArrayList<String> posteNames = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Parcourir les résultats et ajouter les noms de poste à la liste
            while (rs.next()) {
                posteNames.add(rs.getString("nomville"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des noms de la ville: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        // Ajouter les noms de poste au JComboBox dest
        destination.removeAllItems(); // Vider le JComboBox avant d'ajouter les nouveaux éléments
        for (String name : posteNames) {
            destination.addItem(name);
        }
    }
private void loadData() {
    // Vider le modèle de tableau avant de le remplir
    DefaultTableModel model = (DefaultTableModel) agencetb.getModel();
    model.setRowCount(0); // Vide le tableau

    // Récupérer tous les détails
    List<Compagnie> compagnies = repository.readAllCompagnies(); // Récupérer les compagnies
    List<Automobile> automobiles = repository.readAllAutomobiles(); // Récupérer les automobiles
    List<Route> routes = repository.readAllRoutes(); // Récupérer les routes

    // Remplir le tableau avec les données récupérées
    for (int i = 0; i < Math.max(Math.max(compagnies.size(), automobiles.size()), routes.size()); i++) {
        Object[] rowData = new Object[11]; // Ajustez le nombre de colonnes selon vos besoins

        if (i < compagnies.size()) {
            Compagnie compagnie = compagnies.get(i);
            rowData[0] = compagnie.getNomCompagnie();     // Colonne 0: Nom de la compagnie
            rowData[1] = compagnie.getSigleCompagnie();    // Colonne 1: Sigle de la compagnie
            rowData[2] = compagnie.getIdCompagnie();       // Colonne 2: Identifiant de la compagnie
        } else {
            rowData[0] = rowData[1] = rowData[2] = ""; // Champs vides si pas de compagnie
        }

        if (i < automobiles.size()) {
            Automobile automobile = automobiles.get(i);
            rowData[3] = automobile.getNumPlaque();      // Colonne 3: Numéro de plaque
            rowData[4] = automobile.getMarqueAutomobile(); // Colonne 4: Marque de l'automobile
            rowData[5] = automobile.getIdAutomobile();    // Colonne 5: Identifiant de l'automobile
        } else {
            rowData[3] = rowData[4] = rowData[5] = ""; // Champs vides si pas d'automobile
        }

        if (i < routes.size()) {
            Route route = routes.get(i);
            rowData[6] = route.getNomRoute();             // Colonne 6: Nom de la route
            rowData[7] = route.getVilleDepart();          // Colonne 7: Ville de départ
            rowData[8] = route.getVilleEscale();          // Colonne 8: Ville d'escale
            rowData[9] = route.getVilleArrivee();         // Colonne 9: Ville d'arrivée
            rowData[10] = route.getIdRoute();             // Colonne 10: Identifiant de la route
        } else {
            rowData[6] = rowData[7] = rowData[8] = rowData[9] = rowData[10] = ""; // Champs vides si pas de route
        }

        // Ajouter la ligne au modèle du tableau
        model.addRow(rowData);
    }

}
}
