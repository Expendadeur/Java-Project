/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.CONTROLLER.RepositoryExterieurs;
import gcp.MODELES.Tarifications;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISSA 2025
 */
public class TarificationN extends javax.swing.JPanel {
RepositoryExterieurs repository;
    public TarificationN() {
        initComponents();
        IdTarif.setVisible(false);
        repository=new RepositoryExterieurs();
        loadData();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tariftb = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rech = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        typecourier = new javax.swing.JComboBox<>();
        tarif = new javax.swing.JTextField();
        datevalidite = new com.toedter.calendar.JDateChooser();
        IdTarif = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nom = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(122, 112, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(1481, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1292, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(1506, 450));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(700, 450));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("LISTES DE CONFIGURATIONS DE TARIFS APPLIQUES");

        tariftb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TYEPE DE COURIER", "TARIF APPLIQUE", "DATE D'APPLICATION", "IDINTIFIANT TARIFICATION"
            }
        ));
        tariftb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tariftbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tariftb);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("LISTES DE TARIFS AFFICHES PAR TYPE DE COURIER");

        rech.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TYEPE DE COURIER", "TARIF APPLIQUE", "DATE D'APPLICATION"
            }
        ));
        jScrollPane2.setViewportView(rech);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(700, 345));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setText("Type Courier");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Tarif");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Date Validité");

        typecourier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Courrier Ordinaire", "Courrier Recommandé" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)))
                .addGap(102, 102, 102)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tarif)
                    .addComponent(typecourier, 0, 280, Short.MAX_VALUE)
                    .addComponent(datevalidite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IdTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IdTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(typecourier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(datevalidite, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 255)), "ZONE DE COMMANDE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 204));
        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setText("Rechercher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Annuler");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   String typeCourier = (String) typecourier.getSelectedItem();
    String prixFixeStr = tarif.getText().trim();
    Date dateApply = datevalidite.getDate();
    
    // Validation des champs
    if (typeCourier == null || prixFixeStr.isEmpty() || dateApply == null) {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    double prixFixe;
    try {
        prixFixe = Double.parseDouble(prixFixeStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Veuillez entrer un tarif valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création de l'objet Tarifications
    Tarifications tarif = new Tarifications(typeCourier, prixFixe, dateApply); 

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        this, 
        "Êtes-vous sûr de vouloir appliquer ce tarif sur ce type de courrier ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  

    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter la tarification
        repository.addTarification(tarif);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(this, "Tarif appliqué avec succès sur ce type de courrier !");
    } else {
        JOptionPane.showMessageDialog(this, "Ajout annulé.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tariftbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tariftbMouseClicked
         if (evt.getClickCount() == 1) { // Vérifie un double clic
     int selectedRow = tariftb.getSelectedRow();
    if (selectedRow >= 0) {
        // Récupérer les données de la ligne sélectionnée
        int id = (int) tariftb.getValueAt(selectedRow, 3);
        String type = (String) tariftb.getValueAt(selectedRow, 0); // Colonne 0 pour nom
        double prix = (double) tariftb.getValueAt(selectedRow, 1); // Colonne 1 pour régime

        // Assurez-vous que le prix est converti en String pour le champ tarif
        IdTarif.setText(Integer.toString(id));
        tarif.setText(Double.toString(prix)); // Conversion de double à String
        typecourier.setSelectedItem(type);
        
        Date date = (Date) tariftb.getValueAt(selectedRow, 2); // Colonne 2 pour date
        datevalidite.setDate(date);
    }
        }
    }//GEN-LAST:event_tariftbMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String typeCourier = (String) typecourier.getSelectedItem();
    String prixFixeStr = tarif.getText().trim();
    Date dateApply = datevalidite.getDate();
    int Id=Integer.parseInt(IdTarif.getText().trim());
    
    // Validation des champs
    if (typeCourier == null || prixFixeStr.isEmpty() || dateApply == null) {
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    double prixFixe;
    try {
        prixFixe = Double.parseDouble(prixFixeStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Veuillez entrer un tarif valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Création de l'objet Tarifications
    Tarifications tarif = new Tarifications(typeCourier, prixFixe, dateApply,Id); 

    // Confirmation de l'ajout
    int confirmation = JOptionPane.showConfirmDialog(
        this, 
        "Êtes-vous sûr de vouloir de modifier ce tarif sur ce type de courrier ?", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION
    );  

    if (confirmation == JOptionPane.YES_OPTION) {
        // Appeler la méthode pour ajouter la tarification
        repository.updateTarification(tarif);
        // Charger les détails dans le JTable après l'ajout
        loadData();
        initialiser();
        JOptionPane.showMessageDialog(this, "Tarif modifie avec succès sur ce type de courrier !");
    } else {
        JOptionPane.showMessageDialog(this, "modification annulé.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       deleteSelectedTarif();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 String type = nom.getText().trim();
        DefaultTableModel tableModel = (DefaultTableModel) rech.getModel();
                tableModel.setRowCount(0); // Vide le tablea
                // Récupérer les dépêches par destination
                List<Tarifications> detailsList = repository.findTarificationByNom(type);
                
                // Ajouter les résultats au tableau
                for (Tarifications tarif : detailsList) {
                    Object[] rowData = { 
                        tarif.getTypeCourrier(),
                        tarif.getTarif(),
                        tarif.getDateValidite()
                    };
                    tableModel.addRow(rowData);
                }       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      initialiser();
    }//GEN-LAST:event_jButton5ActionPerformed
   private void deleteSelectedTarif() {
        int selectedRow = tariftb.getSelectedRow();
        if (selectedRow != -1) { // Vérifier si une ligne est sélectionnée
            int idtarif = (int) tariftb.getValueAt(selectedRow,3); // Récupérer l'ID de l'agence
            int confirmation = JOptionPane.showConfirmDialog(
                null,
                "Êtes-vous sûr de vouloir supprimer cette tarification ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
            );
            if (confirmation == JOptionPane.YES_OPTION) {
                repository.deleteTarification(idtarif); // Appeler la méthode de suppression
                loadData(); // Mettre à jour le tableau après la suppression
                JOptionPane.showMessageDialog(null, "Tarification supprimée avec succès !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un tarif à supprimer.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdTarif;
    private com.toedter.calendar.JDateChooser datevalidite;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nom;
    private javax.swing.JTable rech;
    private javax.swing.JTextField tarif;
    private javax.swing.JTable tariftb;
    private javax.swing.JComboBox<String> typecourier;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
      List<Tarifications> tarifications = repository.readAllTarifications();
     // Vider le modèle de tableau avant de le remplir
    DefaultTableModel tableModel = (DefaultTableModel) tariftb.getModel();
    tableModel.setRowCount(0); // Vide le tableau
 for (gcp.MODELES.Tarifications tat :tarifications) {
            Object[] rowData = { 
                tat.getTypeCourrier(),
                tat.getTarif(),
                tat.getDateValidite(),
                tat.getIdTarif()
                
            };
            tableModel.addRow(rowData);
        }
    }

    private void initialiser() {
    typecourier.setSelectedIndex(0); // Réinitialiser la sélection
    tarif.setText(""); // Effacer le champ de tarif
    datevalidite.setDate(null); // Réinitialiser la date
    }
}
