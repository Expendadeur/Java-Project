/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gcp.VUE;

import gcp.Database.DatabaseConnection;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISSA 2025
 */
public class RapportAnnuel extends javax.swing.JPanel {

    /**
     * Creates new form RapportAnnuel
     */
    public RapportAnnuel() {
        initComponents();
        getAllCourrierDetails();
    }
    public void getAllCourrierDetails() {
        String query = "SELECT c.Id_Courrier AS Id, c.Poids_Courrier AS poids, c.Type_Courrier AS type, " +
                       "c.Origine_Courrier AS origine, c.Destination_Courrier AS destination, " +
                       "c.Montant_Paye AS montant,c.Statut AS STATUT, " +
                       "d.Nom_Déposant AS nom_deposant, d.Prénom_Déposant AS prenom_deposant, " +
                       "dest.Nom AS nom_destinataire, dest.Prenom AS prenom_destinataire " +
                       "FROM courrier c " +
                       "JOIN déposant d ON c.Id_Courrier = d.Id_Courrier " +
                       "JOIN destinataire dest ON c.Id_Courrier = dest.Id_CourrierEnvoye WHERE c.Statut='Envoyé'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            // Vider le modèle de table avant d'ajouter de nouvelles données
             DefaultTableModel tableModel = (DefaultTableModel) ENVOIE.getModel();
    tableModel.setRowCount(0); 

            while (rs.next()) {
                // Récupérer les informations du courrier
                Object[] row = {
                    rs.getDouble("poids"),
                    rs.getString("type"),
                    rs.getString("origine"),
                    rs.getString("destination"),
                    rs.getDouble("montant"),
                    rs.getString("nom_deposant"),
                    rs.getString("prenom_deposant"),
                    rs.getString("nom_destinataire"),
                    rs.getString("prenom_destinataire"),
                    rs.getString("STATUT")
                };
                // Ajouter la ligne au modèle de la table
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des informations du courrier.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ENVOIE = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(122, 112, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(1404, 50));

        jLabel1.setBackground(new java.awt.Color(122, 112, 140));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STATISTIQUE ANNUEL DES COURIES ENVOYES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel1)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel4.setPreferredSize(new java.awt.Dimension(710, 700));

        ENVOIE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "POID COURIERS", "TYPE", "ORIGINE", "DESTINATION", "MONTANT", "NOM", "PRENOM", "NOM", "PRENOM", "STATUT"
            }
        ));
        jScrollPane3.setViewportView(ENVOIE);

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setText("RAPPART DE COURIES ENVOYES");

        jButton1.setBackground(new java.awt.Color(73, 197, 39));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Imprimer");
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
printTable();
    }//GEN-LAST:event_jButton1ActionPerformed
private void printTable() {
    MessageFormat title= new MessageFormat("RAPPORT DES COURRIERS");
    MessageFormat pieds= new MessageFormat("PAGE {0,number,Integer}");
    
    try {
       PrintRequestAttributeSet set =new HashPrintRequestAttributeSet();
       set.add(OrientationRequested.LANDSCAPE);
       ENVOIE.print(JTable.PrintMode.FIT_WIDTH,title,pieds,true,set,true);
       JOptionPane.showMessageDialog(this, "L'impression reussie.");
    } catch (java.awt.print.PrinterException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur lors de l'impression.");
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ENVOIE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
