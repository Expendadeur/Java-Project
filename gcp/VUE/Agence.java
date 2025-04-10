/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryAgence;
import gcp.MODELES.Agences;
import gcp.MODELES.Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Agence extends javax.swing.JPanel {
 private Map<String, List<String>> citiesByCountry; // Map pour les villes par pays
 private Map<String, String> countryCodes; // Map pour les codes de téléphone
RepositoryAgence repository ;
    public Agence() {
        initComponents();
         repository= new RepositoryAgence();
         initialize();
         loadData();
         Id.setEditable(false);
         Id.setFocusable(false);
       
    }
    
      private void initialize() {
        // Initialisation des Map
        citiesByCountry = new HashMap<>();
        citiesByCountry.put("Burundi", List.of("Bujumbura", "Gitega", "Ngozi", "Rumonge", "Bubanza", "Bururi"));

        // Initialisation des codes de pays
        countryCodes = new HashMap<>();
        countryCodes.put("Burundi", "+257");
        // Remplir le ComboBox de pays
        for (String country : citiesByCountry.keySet()) {
            pays.addItem(country);
        }
        // Écouteur pour le ComboBox de pays
        pays.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCityComboBox();
                updatePhoneCodeTextField(); // Mettre à jour le code de téléphone
            }
        });

    }
    
    
    
 private void updateCityComboBox() {
        ville.removeAllItems(); // Effacer les anciennes villes
        String selectedCountry = (String) pays.getSelectedItem();

        if (selectedCountry != null && citiesByCountry.containsKey(selectedCountry)) {
            for (String city : citiesByCountry.get(selectedCountry)) {
                ville.addItem(city); // Ajouter les villes correspondantes
            }
        }
    }

    private void updatePhoneCodeTextField() {
        String selectedCountry = (String) pays.getSelectedItem();

        if (selectedCountry != null && countryCodes.containsKey(selectedCountry)) {
            codeTel.setText(countryCodes.get(selectedCountry)); // Mettre à jour le JTextField
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        rechercher = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        pays = new javax.swing.JComboBox<>();
        ville = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        codeTel = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nomservice = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        agencetb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(122, 112, 140));
        jPanel2.setPreferredSize(new java.awt.Dimension(1526, 50));

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setText("Rechercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        rechercher.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                rechercherHierarchyChanged(evt);
            }
        });
        rechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rechercherMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(926, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CARACTERISTIQUE D'AGENCE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 763));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("NOM");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("ADRESSE");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("PAYS");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("VILLE");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setText("TELEPHONE FIXE");

        pays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paysActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "ZONE DE COMMANDE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "LES SERVICES"));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setText("Nom Service");

        jButton5.setBackground(new java.awt.Color(0, 0, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Enregistrer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(nomservice, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomservice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adresse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ville, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeTel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        agencetb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOM AGENCE", "ADRESSE", "VILLE", "PAYS", "TELEPHONE AGENCE", "ID AGENCE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        agencetb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agencetbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(agencetb);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("LISTES DES AGENCES");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void paysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paysActionPerformed
       
          
    }//GEN-LAST:event_paysActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String nomP = nom.getText().trim();
    String paysP = (String) pays.getSelectedItem();
    String Adresse = adresse.getText().trim();
    String villeSelectionnee = (String) ville.getSelectedItem();
    String CodeTel = codeTel.getText().trim();
    // Validation des champs
    if (nomP.isEmpty() || Adresse.isEmpty() || CodeTel.isEmpty()) {
        JOptionPane.showMessageDialog(Agence.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }
    Agences agence = new Agences(nomP, Adresse, villeSelectionnee, paysP, CodeTel); 
    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        Agence.this, 
        "Êtes-vous sûr de vouloir ajouter cet Agence et service ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter l'agence
        repository.createAgence(agence);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(Agence.this, "Agence ajoutée avec succès !");
    } else {
        JOptionPane.showMessageDialog(Agence.this, "Ajout annulé.");
    }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rechercherHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_rechercherHierarchyChanged
        //loadDataparnom();
    }//GEN-LAST:event_rechercherHierarchyChanged

    private void agencetbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agencetbMouseClicked
        if (evt.getClickCount() == 1) { // Vérifie un double clic
            int selectedRow = agencetb.getSelectedRow();
            if (selectedRow >= 0) {
                // Récupérer les données de la ligne sélectionnée
                int id= (int) agencetb.getValueAt(selectedRow,5);
                String nomPoste = (String) agencetb.getValueAt(selectedRow, 0); // Colonne 0 pour nom
                String adresses = (String) agencetb.getValueAt(selectedRow, 1); // Colonne 1 pour régime
                String Pays = (String) agencetb.getValueAt(selectedRow, 2); // Colonne 2 pour pays
                String vill = (String) agencetb.getValueAt(selectedRow, 3); // Colonne 3 pour ville
                String numBP = (String) agencetb.getValueAt(selectedRow, 4); // Colonne 4 pour numéro BP
                Id.setText(Integer.toString(id));
                nom.setText(nomPoste);
                adresse.setText(adresses);
                pays.setSelectedItem(Pays);
                ville.setSelectedItem(vill);
                codeTel.setText(numBP);
            }
        }
    }//GEN-LAST:event_agencetbMouseClicked

    //Suppression d'une agence
     private void deleteSelectedAgence() {
        int selectedRow = agencetb.getSelectedRow();
        if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
            int idAgence = (int) agencetb.getValueAt(selectedRow,5); // Récupérer l'ID de l'agence
            int confirmation = JOptionPane.showConfirmDialog(
                null,
                "Êtes-vous sûr de vouloir supprimer cette agence ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
            );
            if (confirmation == JOptionPane.YES_OPTION) {
                repository.deleteAgence(idAgence); // Appeler la méthode de suppression
                loadData(); // Mettre à jour le tableau après la suppression
                JOptionPane.showMessageDialog(null, "Agence supprimée avec succès !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une agence à supprimer.");
        }
    }
    
    
    private void rechercherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechercherMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercherMouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String nomP = nom.getText().trim();
    String paysP = (String) pays.getSelectedItem();
    String Adresse = adresse.getText().trim();
    String villeSelectionnee = (String) ville.getSelectedItem();
    String CodeTel = codeTel.getText().trim();
    int id=Integer.parseInt(Id.getText());
    
    // Validation des champs
    if (nomP.isEmpty() || Adresse.isEmpty() || CodeTel.isEmpty()) {
        JOptionPane.showMessageDialog(Agence.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création de l'objet Agences
    Agences agence = new Agences(nomP, Adresse, villeSelectionnee, paysP, CodeTel,id); 

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        Agence.this, 
        "Êtes-vous sûr de vouloir de modifier cet Agence ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter l'agence

        repository.updateAgence(agence);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(Agence.this, "Agence modifié avec succès !");
    } else {
        JOptionPane.showMessageDialog(Agence.this, "modifié annulé.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteSelectedAgence();
    }//GEN-LAST:event_jButton3ActionPerformed
private void searchAgences() {
    String keyword = rechercher.getText().toString();
    RepositoryAgence repository = new RepositoryAgence();
    List<Agences> resultAgences = repository.searchAgences(keyword);

    // Vider le modèle de table avant d'ajouter de nouvelles données
    DefaultTableModel tableModel = (DefaultTableModel) agencetb.getModel();
    tableModel.setRowCount(0); // Vider le modèle

    // Ajouter les résultats à la table
    for (Agences agence : resultAgences) {
        Object[] row = {
            agence.getNomAgence(),
            agence.getAdresse(),
            agence.getVille(),
            agence.getPays(),
            agence.getNumTel(),
            agence.getIdAgence()
        };
        tableModel.addRow(row); // Ajouter chaque ligne au modèle de la table
    }
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   String nomService = nomservice.getText().trim(); // Assurez-vous que 'nomservice' est bien le bon champ de texte

    // Vérifiez que le champ n'est pas vide
    if (nomService.isEmpty()) {
        JOptionPane.showMessageDialog(Agence.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Service service = new Service(nomService); 

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        Agence.this, 
        "Êtes-vous sûr de vouloir ajouter cet service ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  

    if (confirmation == JOptionPane.YES_OPTION) {
        repository.createService(service);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(Agence.this, "Service ajoutée avec succès !");
    } else {
        JOptionPane.showMessageDialog(Agence.this, "Ajout annulé.");
    } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 searchAgences();
    }//GEN-LAST:event_jButton4ActionPerformed


     
    private void initialiser() {
    // Réinitialiser les champs de texte
    nom.setText(""); // Réinitialiser le champ de texte pour le nom
    adresse.setText(""); // Réinitialiser le champ de texte pour l'adresse
    codeTel.setText(""); // Réinitialiser le champ de texte pour le code de téléphone
    
    // Réinitialiser les JComboBox
    pays.setSelectedIndex(0); // Sélectionner le premier pays par défaut
    ville.setSelectedIndex(0); // Sélectionner la première ville par défaut

}
    
    
    private void loadDataparnom() {
    String keyword = rechercher.getText().trim();
    DefaultTableModel tableModel = (DefaultTableModel) agencetb.getModel();
    tableModel.setRowCount(0); // Vide le tableau

   List<Agences> agences = repository.searchAgences(keyword);
   
 for (gcp.MODELES.Agences agence :agences) {
            Object[] rowData = {
                agence.getNomAgence(),
                agence.getAdresse(),
                agence.getVille(),
                agence.getPays(),
                agence.getNumTel(),
                agence.getIdAgence()
            };
            tableModel.addRow(rowData);
        }

    //JOptionPane.showMessageDialog(this, "Détails chargés avec succès !");
}
    
    
    private void loadData() {
    // Vider le modèle de tableau avant de le remplir
    DefaultTableModel tableModel = (DefaultTableModel) agencetb.getModel();
    tableModel.setRowCount(0); // Vide le tableau

    // Récupérer les détails des courriers
    List<gcp.MODELES.Agences> detailsList = repository.readAllAgences();
 for (gcp.MODELES.Agences agence :detailsList) {
            Object[] rowData = {
                
                agence.getNomAgence(),
                agence.getAdresse(),
                agence.getVille(),
                agence.getPays(),
                agence.getNumTel(),
                agence.getIdAgence(),
            };
            tableModel.addRow(rowData);
        }

    //JOptionPane.showMessageDialog(this, "Détails chargés avec succès !");
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JTextField adresse;
    private javax.swing.JTable agencetb;
    private javax.swing.JTextField codeTel;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nomservice;
    private javax.swing.JComboBox<String> pays;
    private javax.swing.JTextField rechercher;
    private javax.swing.JComboBox<String> ville;
    // End of variables declaration//GEN-END:variables
}
