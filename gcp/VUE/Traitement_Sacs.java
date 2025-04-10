/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryDepecheSacs;
import gcp.Database.DatabaseConnection;
import gcp.MODELES.Depeche;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Traitement_Sacs extends javax.swing.JPanel {
RepositoryDepecheSacs repository;
    public Traitement_Sacs() {
        initComponents();
        repository=new RepositoryDepecheSacs();
        loadPosteNamesIntoComboBox(originedepeche);
        loadPosteNamesIntoComboBox(destinationdepeche);
        loadData();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        originedepeche = new javax.swing.JComboBox<>();
        destinationdepeche = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        pois = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        NumDepeche = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        meme = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sacs = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        depechetb = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        recherche = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CARACTERISTIQUE DU COURIERS A DEPECHER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 3, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Origine Dépèche");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Destination Dépèche");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Description");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Poids Dépèche");

        originedepeche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        destinationdepeche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel9.setText("N° Depeche");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(10, 10, 10)))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pois, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinationdepeche, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(NumDepeche, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(originedepeche, javax.swing.GroupLayout.Alignment.LEADING, 0, 229, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel9)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(NumDepeche, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(originedepeche, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationdepeche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pois, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "BOUTONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 3, 18))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Créer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setText("Modifier");

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Supprimer");

        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setText("Afficher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        meme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Num Depeche", "Poids Depeche", "Origine", "Destination", "Description"
            }
        ));
        jScrollPane2.setViewportView(meme);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("LISTES DE COURIERS ORDINAIRES DE MEME DESTINATION");

        sacs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "POIDS", "DESCRIPTION", "POIDS SAC INTERNE", "DETAILS"
            }
        ));
        jScrollPane3.setViewportView(sacs);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("LISTES DE PETITS SACS  ORDINAIRES DE MEME DESTINATION");

        depechetb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Depeche", "Poids Depeche", "Origine", "Destination", "Description"
            }
        ));
        depechetb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depechetbMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(depechetb);

        jPanel4.setBackground(new java.awt.Color(122, 112, 140));
        jPanel4.setPreferredSize(new java.awt.Dimension(733, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CREATION D'UN DEPECHE VIDE A ENVOYER");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(346, 346, 346)
                .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("LISTES DE LA DEPECHE CREES");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Afficher");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(jButton5)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(240, 240, 240))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String num = NumDepeche.getText().trim();
    String origine = originedepeche.getSelectedItem().toString().trim();
    String destination = destinationdepeche.getSelectedItem().toString().trim();
    String descripTion = description.getText().trim();
    double Poids = 0.0; // Initialisation du poids

    // Validation des champs
    if (num.isEmpty() || origine.isEmpty() || destination.isEmpty() || descripTion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérification du poids
    String poidsText = pois.getText().trim();
    if (poidsText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez entrer un poids valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        try {
            Poids = Double.parseDouble(poidsText); // Conversion du poids
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le poids doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Création des objets
    Depeche depeche = new Depeche(num, Poids, origine, destination, descripTion);

    int confirmation = JOptionPane.showConfirmDialog(
        this, 
        "Êtes-vous sûr de vouloir traiter cette dépêche et ces informations ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  
    
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter les enregistrements
        RepositoryDepecheSacs repositorys = new RepositoryDepecheSacs();
        repositorys.addDepêche(depeche);
        
        // Optionnel : Charger les données si nécessaire
        loadData(); // Si vous avez une méthode pour recharger les données
        
        // Réinitialiser les champs
        initialiser(); // Si vous avez une méthode pour réinitialiser les champs
        
        JOptionPane.showMessageDialog(this, "Les enregistrements ont été ajoutés avec succès !");
    } else {
        JOptionPane.showMessageDialog(this, "Ajout annulé.");
    } 
    }//GEN-LAST:event_jButton1ActionPerformed

    
     private void loadDataMeme(String destination) {
          DefaultTableModel tableModel = (DefaultTableModel) meme.getModel();
        tableModel.setRowCount(0); // Clear existing rows

        // Load dépêches
        String depQuery = "SELECT Id_Courrier,Poids_Courrier,Origine_Courrier,Destination_Courrier,Description_Courrier " +
                          "FROM courrier  WHERE Destination_Courrier = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(depQuery)) {
            pstmt.setString(1, destination);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    "courrier",
                    rs.getInt("Id_Courrier"),
                    rs.getBigDecimal("Poids_Courrier"),
                    rs.getString("Origine_Courrier"),
                    rs.getString("Destination_Courrier"),
                    rs.getString("Description_Courrier ")
                };
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des courriers.");
        }
    }
    
    
    
    
    
    
    
      private void loadData(String destination) {
          DefaultTableModel tableModel = (DefaultTableModel) sacs.getModel();
        tableModel.setRowCount(0); // Clear existing rows

        // Load dépêches
        String depQuery = "SELECT Id_Dépêche, Poids_Dépêche, Description " +
                          "FROM dépêche WHERE Destination_Dépêche = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(depQuery)) {
            pstmt.setString(1, destination);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    "Dépêche",
                    rs.getBigDecimal("Poids_Dépêche"),
                    rs.getString("Description")
                };
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des dépêches.");
        }
        // Load sacs internes (example without a filter)
        String sacQuery = "SELECT Id_SacPetitSac, Poids_SacInterne, Details_SacInterne " +
                          "FROM sacinterne";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sacQuery);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = {
                    "Sac Interne",
                    rs.getBigDecimal("Poids_SacInterne"),
                    rs.getString("Details_SacInterne")
                };
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des sacs internes.");
        }
    }
    
    
    
    private void depechetbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depechetbMouseClicked
     if (evt.getClickCount() == 1) { // Vérifie un clic simple
        int selectedRow = depechetb.getSelectedRow();
        if (selectedRow >= 0) {
            // Récupérer les valeurs de la ligne sélectionnée
            String IdDep = (String) depechetb.getValueAt(selectedRow, 0); // Colonne 0 pour l'identifiant de la dépêche
            double Poid = 0.0; // Initialisation du poids
            
            // Vérification du type de valeur pour éviter les exceptions
            Object poidsValue = depechetb.getValueAt(selectedRow, 1); // Colonne 1 pour le poids
            if (poidsValue instanceof Number) {
                Poid = ((Number) poidsValue).doubleValue(); // Conversion si c'est un nombre
            } else if (poidsValue instanceof String) {
                try {
                    Poid = Double.parseDouble((String) poidsValue); // Conversion si c'est une chaîne
                } catch (NumberFormatException e) {
                    Poid = 0.0; // Valeur par défaut en cas d'erreur
                }
            }

            String origin = (String) depechetb.getValueAt(selectedRow, 2); // Colonne 2 pour l'origine
            String destin = (String) depechetb.getValueAt(selectedRow, 3); // Colonne 3 pour la destination
            String descr = (String) depechetb.getValueAt(selectedRow, 4); // Colonne 4 pour la description
            
            // Mise à jour des champs
            NumDepeche.setText(IdDep);
            pois.setText(String.valueOf(Poid)); // Convertir le poids en chaîne pour le champ de texte
            originedepeche.setSelectedItem(origin);
            description.setText(descr);
            destinationdepeche.setSelectedItem(destin);
        }
    }
    }//GEN-LAST:event_depechetbMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       String destination = recherche.getText().trim();
        DefaultTableModel tableModel = (DefaultTableModel) depechetb.getModel();
                tableModel.setRowCount(0); // Vide le tablea
                // Récupérer les dépêches par destination
                List<Depeche> detailsList = repository.findDépêchesByDestination(destination);
                
                // Ajouter les résultats au tableau
                for (Depeche depeche : detailsList) {
                    Object[] rowData = { 
                        depeche.getIdDepeche(),
                        depeche.getPoidsDepeche(),
                        depeche.getOrigineDepeche(),
                        depeche.getDestinationDepeche(),
                        depeche.getDescription()
                    };
                    tableModel.addRow(rowData);
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String destination = recherche.getText().trim();
        loadDataMeme(destination);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NumDepeche;
    private javax.swing.JTable depechetb;
    private javax.swing.JTextArea description;
    private javax.swing.JComboBox<String> destinationdepeche;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable meme;
    private javax.swing.JComboBox<String> originedepeche;
    private javax.swing.JTextField pois;
    private javax.swing.JTextField recherche;
    private javax.swing.JTable sacs;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
         // Vider le modèle de tableau avant de le remplir
    DefaultTableModel tableModel = (DefaultTableModel) depechetb.getModel();
    tableModel.setRowCount(0); // Vide le tableau

    // Récupérer les détails des courriers
    List<gcp.MODELES.Depeche> detailsList = repository. readAllDépêches();
 for (gcp.MODELES.Depeche depeche :detailsList) {
            Object[] rowData = { 
                depeche.getIdDepeche(),
                depeche.getPoidsDepeche(),
                depeche.getOrigineDepeche(),
                depeche.getDestinationDepeche(),
                depeche.getDescription()
                
            };
            tableModel.addRow(rowData);
        }
    }

    private void initialiser() {
       // Réinitialiser les champs de texte
    NumDepeche.setText(""); // Réinitialiser le champ pour l'identifiant de la dépêche
    pois.setText(""); // Réinitialiser le champ pour le poids
    description.setText(""); // Réinitialiser le champ pour la description

    // Réinitialiser les listes déroulantes
    originedepeche.setSelectedIndex(0); // Sélectionner la première option de la liste d'origine
    destinationdepeche.setSelectedIndex(0);
    }
}
