/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryEmploye;
import gcp.Database.DatabaseConnection;
import gcp.MODELES.Employe;
import gcp.MODELES.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionEmployes extends javax.swing.JPanel {
     RepositoryEmploye repository ;
    public GestionEmployes() {
        initComponents();
        loadPosteNamesIntoComboBox(service);
        loadAgenceNamesIntoComboBox(jComboBox2);
        repository=new RepositoryEmploye();
        Id.setEditable(false);
        Id.setFocusable(false);
        loadData();
    }
  public void loadPosteNamesIntoComboBox(JComboBox<String> destination) {
        String query = "SELECT Nom_Service FROM service"; // Votre requête SQL pour récupérer les noms de poste
        ArrayList<String> posteNames = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Parcourir les résultats et ajouter les noms de poste à la liste
            while (rs.next()) {
                posteNames.add(rs.getString("Nom_Service"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des noms de service: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        // Ajouter les noms de poste au JComboBox dest
        destination.removeAllItems(); // Vider le JComboBox avant d'ajouter les nouveaux éléments
        for (String name : posteNames) {
            destination.addItem(name);
        }
    }
  
  
  public void loadAgenceNamesIntoComboBox(JComboBox<String> destination) {
        String query = "SELECT Nom_Agence FROM Agence"; // Votre requête SQL pour récupérer les noms de poste
        ArrayList<String> posteNames = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Parcourir les résultats et ajouter les noms de poste à la liste
            while (rs.next()) {
                posteNames.add(rs.getString("Nom_Agence"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des noms d'agence: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableE = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nomE = new javax.swing.JTextField();
        prenomE = new javax.swing.JTextField();
        matriculeE = new javax.swing.JTextField();
        telephone = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        service = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        dateNaissance = new com.toedter.calendar.JDateChooser();
        dateEmbouche = new com.toedter.calendar.JDateChooser();
        role = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Id = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(122, 112, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(1449, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DES EMPLOYES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(567, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(403, 403, 403))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tableE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOM", "PRENOM", "MATRICULE", "DATE DE NAISSANCE", "DATE D'EMBOUCHE", "TELEPHONE", "USERNAME", "PASSWORD", "ID"
            }
        ));
        tableE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableE);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("LISTE DES EMPLOYES AVEC LEURS SERVICES");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CARACTERISTIQUE D'EMPLOYE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("DATE D'EMBOUCHE");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("PRENOM");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("MATRICULE");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("DATE DE NAISSANCE");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setText("NOM");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setText("TELEPHONE");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setText("USERNAME");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel9.setText("PASSWORD");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel10.setText("Service");

        service.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setText("Agence");
        jLabel12.setToolTipText("");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "agent" }));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel13.setText("Role");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Enregistrer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton6.setText("Modifier");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(70, 70, 70)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(matriculeE, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nomE, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(prenomE, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateEmbouche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel6))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(dateEmbouche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nomE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prenomE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(matriculeE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8)
                                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceActionPerformed
         /*Service selectedService = (Service) service.getSelectedItem();
        if (selectedService != null) {
            int idService = selectedService.getIdService();
            System.out.println("ID du service sélectionné : " + idService);
        }*/
    }//GEN-LAST:event_serviceActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    String nomEM = nomE.getText().trim();
    String Prenom = prenomE.getText().trim();
    String matricule = matriculeE.getText().trim();
    Date datenaissance = dateNaissance.getDate();
    Date dateembouche = dateEmbouche.getDate();
    String Username = username.getText().trim();
    String Tel = telephone.getText().trim();
    String motdepasse = password.getText().trim();
    String nomservice = (String) service.getSelectedItem();
    String nomagence = (String) jComboBox2.getSelectedItem();
String Role = (String) role.getSelectedItem();
    // Validation des champs
    if (nomEM.isEmpty() || Prenom.isEmpty() || matricule.isEmpty()) {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Récupérer l'ID du service
    int idservice = getIdByServiceName(nomservice);
    if (idservice == -1) {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Service non trouvé.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Récupérer l'ID de l'agence
    int idagence = getIdByAgenceName(nomagence);
    if (idagence == -1) {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Agence non trouvée.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création de l'objet Employe
    Employe employe = new Employe(nomEM, Prenom, matricule, datenaissance, dateembouche, Tel, Username, motdepasse, idservice, idagence,Role); 

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        GestionEmployes.this, 
        "Êtes-vous sûr de vouloir d'Ajouter cet Employe ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter l'employé
        repository.createEmploye(employe);
        // Charger les détails dans le JTable après l'ajout
         loadData();
        // initialiser();
        JOptionPane.showMessageDialog(GestionEmployes.this, "Employé ajouté avec succès !");
    } else {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Ajout annulé.");
    } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEMouseClicked
        if (evt.getClickCount() == 1) { // Vérifie un double clic
            int selectedRow = tableE.getSelectedRow();
            if (selectedRow >= 0) {
                // Récupérer les données de la ligne sélectionnée
                String nom = (String) tableE.getValueAt(selectedRow, 0); // Colonne 0 pour nom
                String prenom = (String) tableE.getValueAt(selectedRow, 1); // Colonne 1 pour régime
                String matricule = (String) tableE.getValueAt(selectedRow, 2); // Colonne 2 pour pays
                Date dateNai = (Date) tableE.getValueAt(selectedRow, 3); // Colonne 3 pour ville
                Date dateEmbou = (Date) tableE.getValueAt(selectedRow, 4); // Colonne 6 pour état BP
                String num = (String) tableE.getValueAt(selectedRow, 5); // Colonne 4 pour numéro BP
                String Username = (String) tableE.getValueAt(selectedRow, 6); // Colonne 5 pour type BP
                String Password = (String) tableE.getValueAt(selectedRow, 7); 
                int id = 0; // Initialisation de l'identifiant
        Object idValue = tableE.getValueAt(selectedRow, 8); // Colonne 8 pour identifiant
        
        if (idValue instanceof Number) {
            id = ((Number) idValue).intValue(); // Conversion si c'est un nombre
        } else if (idValue instanceof String) {
            id = Integer.parseInt((String) idValue); // Conversion si c'est une chaîne
        }

        // Remplir les champs avec les données récupérées
        nomE.setText(nom);
        prenomE.setText(prenom);
        dateNaissance.setDate(dateNai);
        dateEmbouche.setDate(dateEmbou);
        matriculeE.setText(num);
        password.setText(Password);
        username.setText(Username); // Utiliser le bon champ pour le nom d'utilisateur
        Id.setText(String.valueOf(id)); // Conver
            }
        }
    }//GEN-LAST:event_tableEMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      String nomEM = nomE.getText().trim();
    String prenom = prenomE.getText().trim();
    String matricule = matriculeE.getText().trim();
    Date datenaissance = dateNaissance.getDate();
    Date dateembouche = dateEmbouche.getDate();
    String Username = username.getText().trim();
    String tel = telephone.getText().trim();
    String motdepasse = password.getText().trim();
    String nomservice = (String) service.getSelectedItem();
    String nomagence = (String) jComboBox2.getSelectedItem();
    
    // Vérification si le champ Id est vide
    String idText = Id.getText().trim();
    int id = 0; // Initialisation de l'ID
    if (!idText.isEmpty()) {
        id = Integer.parseInt(idText);
    } else {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Veuillez entrer un identifiant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return; // Sortir de la méthode si l'ID est vide
    }

    // Validation des champs
    if (nomEM.isEmpty() || prenom.isEmpty() || matricule.isEmpty()) {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Récupérer l'ID du service
    int idservice = getIdByServiceName(nomservice);
    if (idservice == -1) {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Service non trouvé.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Récupérer l'ID de l'agence
    int idagence = getIdByAgenceName(nomagence);
    if (idagence == -1) {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Agence non trouvée.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création de l'objet Employe
    Employe employe = new Employe(nomEM, prenom, matricule, datenaissance, dateembouche, tel, Username, motdepasse, idservice, idagence, id); 

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        GestionEmployes.this, 
        "Êtes-vous sûr de vouloir modifier cet Employé ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour mettre à jour l'employé
        repository.updateEmploye(employe);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(GestionEmployes.this, "Employé modifié avec succès !");
    } else {
        JOptionPane.showMessageDialog(GestionEmployes.this, "Modification annulée.");
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      deleteSelectedEmploye();
    }//GEN-LAST:event_jButton1ActionPerformed
// Méthode pour récupérer l'ID du service par son nom
private int getIdByServiceName(String serviceName) {
    String query = "SELECT Id_Service FROM Service WHERE Nom_Service = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, serviceName);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("Id_Service");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Gérer l'exception selon vos besoins
    }
    return -1; // Retournez -1 si le service n'est pas trouvé
}

// Méthode pour récupérer l'ID de l'agence par son nom
private int getIdByAgenceName(String agenceName) {
    String query = "SELECT Id_Agence FROM Agence WHERE Nom_Agence = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, agenceName);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("Id_Agence");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Gérer l'exception selon vos besoins
    }
    return -1; // Retournez -1 si l'agence n'est pas trouvée
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private com.toedter.calendar.JDateChooser dateEmbouche;
    private com.toedter.calendar.JDateChooser dateNaissance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField matriculeE;
    private javax.swing.JTextField nomE;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField prenomE;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JComboBox<String> service;
    private javax.swing.JTable tableE;
    private javax.swing.JTextField telephone;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
    List<Employe> employes = repository.readAllEmployes(); // Récupérer la liste des employés
    // Effacer les données existantes dans le tableau
    DefaultTableModel model = (DefaultTableModel) tableE.getModel();
    model.setRowCount(0); // Réinitialiser le modèle du tableau

    // Remplir le tableau avec les données récupérées
    for (Employe employe : employes) {
        Object[] rowData = {
            employe.getNomEmploye(),                // Colonne 0: Nom
            employe.getPrenomEmploye(),             // Colonne 1: Prénom
            employe.getMatricule(),          // Colonne 2: Matricule
            employe.getDateNaiss(),          // Colonne 3: Date de naissance
            employe.getDateEmb(),            // Colonne 4: Date d'embauche
            employe.getNumTel(),             // Colonne 5: Numéro de téléphone
            employe.getLogin(),              // Colonne 6: Nom d'utilisateur
            employe.getPswd(),               // Colonne 7: Mot de passe
            employe.getIdEmploye()           // Colonne 8: Identifiant
        };
        model.addRow(rowData); // Ajouter la ligne au modèle du tableau
    }
    }
    //Suppression d'une agence
     private void deleteSelectedEmploye() {
        int selectedRow = tableE.getSelectedRow();
        if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
            int idEmploye = (int) tableE.getValueAt(selectedRow,8); // Récupérer l'ID de l'agence
            int confirmation = JOptionPane.showConfirmDialog(
                null,
                "Êtes-vous sûr de vouloir supprimer cette Employe ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
            );
            if (confirmation == JOptionPane.YES_OPTION) {
                repository.deleteEmploye(idEmploye); // Appeler la méthode de suppression
                loadData(); // Mettre à jour le tableau après la suppression
                JOptionPane.showMessageDialog(null, "Employe supprimée avec succès !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une Employe à supprimer.");
        }
    }
    private void initialiser() {
       // Vider les champs de texte
    nomE.setText("");           // Champ pour le nom
    prenomE.setText("");        // Champ pour le prénom
    matriculeE.setText("");     // Champ pour le matricule
    password.setText("");      // Champ pour le mot de passe
    username.setText("");      // Champ pour le nom d'utilisateur
    Id.setText("");             // Champ pour l'identifiant
    matriculeE.setText("");     // Champ pour le numéro de téléphone
    // Réinitialiser les sélecteurs de date
    dateNaissance.setDate(null); // Réinitialiser la date de naissance
    dateEmbouche.setDate(null);  // Réinitialiser la date d'embauche
    // Optionnel : Remettre le focus sur le premier champ
    nomE.requestFocus();     
    }
}
