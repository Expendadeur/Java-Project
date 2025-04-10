/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryPosteBoitePostale;
import gcp.MODELES.BoitePostale;
import gcp.MODELES.Poste;
import gcp.MODELES.PosteBoiteDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionPoste extends javax.swing.JPanel {
private Map<String, List<String>> citiesByCountry;
 RepositoryPosteBoitePostale repository ;
    public GestionPoste() {
        initComponents();
        repository= new RepositoryPosteBoitePostale();
         initialize();
         loadData();
         IdPoste.setEditable(false);
         IdBP.setEditable(false);
         IdPoste.setFocusable(false);
         IdBP.setFocusable(false);
    }
private void initialize() {
    citiesByCountry = new HashMap<>();
    citiesByCountry.put("Burundi", List.of("Bujumbura", "Gitega", "Ngozi","Rumonge","Bubanza","Bururi"));
    // Remplir le ComboBox de pays si ce n'est pas déjà fait
    for (String country : citiesByCountry.keySet()) {
        pays.addItem(country);
    }
      // Écouteur pour le ComboBox de pays
        pays.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCityComboBox();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nom = new javax.swing.JTextField();
        regime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pays = new javax.swing.JComboBox<>();
        ville = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        etat = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBP = new javax.swing.JTable();
        IdPoste = new javax.swing.JTextField();
        IdBP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(122, 112, 140));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 51)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1356, 50));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion Des Postes et Des Boites Postales");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(336, 336, 336))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 2, 3, 2, new java.awt.Color(0, 0, 0)), "GESTION DES POSTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("Nom Poste");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setText("Pays");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setText("Regime");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setText("Ville");

        ville.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nom)
                    .addComponent(regime)
                    .addComponent(pays, 0, 300, Short.MAX_VALUE)
                    .addComponent(ville, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pays, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regime, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 2, 3, 2, new java.awt.Color(0, 0, 0)), "GESTION DE BOITES POSTALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Numero Boite Postal");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Type Boite Postal");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Etat de le Boite Postal");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boîte Postale Standard", "Boîte Postale Commerciale", "Boîte Postale Privée", "Boîte Postale Numérique" }));

        etat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive", "Suspendue", "Fermée" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numero)
                    .addComponent(type, 0, 267, Short.MAX_VALUE)
                    .addComponent(etat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(54, 54, 54))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "ZONE DE COMMANDES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton3.setText("Visualiser");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tableBP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOM", "PAYS", "REGIME", "VILLE", "ETAT", "NUMERO BOITE POSTALE", "TYPE BOITE POSTAL", "Poste N°", "N° Boite Postale"
            }
        ));
        tableBP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBP);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setText("Identifiant de la Boite Postale");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel10.setText("Identifiant du Poste");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(IdBP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(IdPoste, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IdBP, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdPoste, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String nomP = nom.getText().trim();
    String paysP = (String) pays.getSelectedItem();
    String regimeP = regime.getText().trim();
    String vil = (String) ville.getSelectedItem();
    String Type = (String) type.getSelectedItem();
    String numeroBP = numero.getText().trim(); // Garder en tant que String
    String Etat = (String) etat.getSelectedItem();
    
    // Validation des champs
    if (nomP.isEmpty() || regimeP.isEmpty() || numeroBP.isEmpty()) {
        JOptionPane.showMessageDialog(GestionPoste.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérifier le format du numéro de boîte postale
    if (!numeroBP.matches("BP \\d{1,4}")) { // Vérifie le format "BP 1234"
        JOptionPane.showMessageDialog(GestionPoste.this, "Le numéro de boîte postale doit être au format 'BP XXXX' où XXXX est un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Créer les objets Poste et BoitePostale
    Poste poste = new Poste(nomP,regimeP, paysP,vil);
    BoitePostale bp = new BoitePostale(numeroBP, Type, Etat); // Utiliser le format de chaîne

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        GestionPoste.this, 
        "Êtes-vous sûr de vouloir ajouter ce poste et leur détail ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter le poste et la boîte postale
        repository.createPosteAndBoitePostale(poste, bp);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(GestionPoste.this, "Poste ajouté avec succès !");
    } else {
        JOptionPane.showMessageDialog(GestionPoste.this, "Ajout annulé.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableBPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBPMouseClicked
          if (evt.getClickCount() == 1) { // Vérifie un double clic
            int selectedRow = tableBP.getSelectedRow();
            if (selectedRow >= 0) {
                // Récupérer les données de la ligne sélectionnée
                String nomPoste = (String) tableBP.getValueAt(selectedRow, 0); // Colonne 0 pour nom
                String Regime = (String) tableBP.getValueAt(selectedRow, 1); // Colonne 1 pour régime
                String Pays = (String) tableBP.getValueAt(selectedRow, 2); // Colonne 2 pour pays
                String vill = (String) tableBP.getValueAt(selectedRow, 3); // Colonne 3 pour ville
                String etatBP = (String) tableBP.getValueAt(selectedRow, 4); // Colonne 6 pour état BP
                String numBP = (String) tableBP.getValueAt(selectedRow, 5); // Colonne 4 pour numéro BP
                String typeBP = (String) tableBP.getValueAt(selectedRow, 6); // Colonne 5 pour type BP
                
                int idBP = (int) tableBP.getValueAt(selectedRow, 8); // Colonne 4 pour numéro BP
                int idposte = (int) tableBP.getValueAt(selectedRow, 7); 
                // Remplir les champs avec les données récupérées
                nom.setText(nomPoste);
                regime.setText(Regime);
                pays.setSelectedItem(Pays);
                ville.setSelectedItem(vill);
                numero.setText(numBP);
                type.setSelectedItem(typeBP);
                etat.setSelectedItem(etatBP);
               IdPoste.setText(String.valueOf(idposte)); // Convertir en String
    IdBP.setText(String.valueOf(idBP)); // Convertir en String
            }
        }
    }//GEN-LAST:event_tableBPMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String nomP = nom.getText().trim();
    String paysP = (String) pays.getSelectedItem();
    String regimeP = regime.getText().trim();
    String vil = (String) ville.getSelectedItem();
    String Type = (String) type.getSelectedItem();
    String numeroBP = numero.getText().trim(); // Garder en tant que String
    String Etat = (String) etat.getSelectedItem();
    int idposte = Integer.parseInt(IdPoste.getText()); // Correction ici
    int idBP = Integer.parseInt(IdBP.getText());
    
    // Validation des champs
    if (nomP.isEmpty() || regimeP.isEmpty() || numeroBP.isEmpty()) {
        JOptionPane.showMessageDialog(GestionPoste.this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérifier le format du numéro de boîte postale
    if (!numeroBP.matches("BP \\d{1,4}")) { // Vérifie le format "BP 1234"
        JOptionPane.showMessageDialog(GestionPoste.this, "Le numéro de boîte postale doit être au format 'BP XXXX' où XXXX est un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Créer les objets Poste et BoitePostale
    Poste poste = new Poste(nomP,regimeP, paysP,vil,idposte);
    BoitePostale bp = new BoitePostale(numeroBP, Type, Etat,idBP); // Utiliser le format de chaîne

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        GestionPoste.this, 
        "Êtes-vous sûr de vouloir de modifier ce poste et leur détail ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter le poste et la boîte postale
        repository.updatePosteAndBoite(poste, bp);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
    } else {
        JOptionPane.showMessageDialog(GestionPoste.this, "modification annulé.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed
// Supposons que votre JTable s'appelle "table"

   
    
    
    private void initialiser(){
     nom.setText(""); 
    pays.setSelectedIndex(0);
    regime.setText(""); 
    ville.setSelectedIndex(0);
    type.setSelectedIndex(0); 
    numero.setText(""); 
    etat.setSelectedIndex(0); 
}
private void loadData() {
    // Vider le modèle de tableau avant de le remplir
    DefaultTableModel tableModel = (DefaultTableModel) tableBP.getModel();
    tableModel.setRowCount(0); // Vide le tableau

    // Récupérer les détails des courriers
    List<PosteBoiteDetails> detailsList = repository.readPosteBoiteDetails();

    // Remplir le tableau avec les données récupérées
    for (PosteBoiteDetails details : detailsList) {
        gcp.MODELES.Poste poste = details.getPoste();
        BoitePostale boite = details.getBoitePostale();
        Object[] rowData = {
            poste.getNomPoste(),
            poste.getPays(),
            poste.getRegime(),
            poste.getVille(),
            boite.getEtatBP(),
            boite.getNumBP(),
            boite.getTypeBP(),
            poste.getIdPoste(),
            boite.getIdBP()
        };
        tableModel.addRow(rowData); // Ajoute la nouvelle ligne au tableau
    }

    //JOptionPane.showMessageDialog(this, "Détails chargés avec succès !");
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdBP;
    private javax.swing.JTextField IdPoste;
    private javax.swing.JComboBox<String> etat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numero;
    private javax.swing.JComboBox<String> pays;
    private javax.swing.JTextField regime;
    private javax.swing.JTable tableBP;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JComboBox<String> ville;
    // End of variables declaration//GEN-END:variables
}
