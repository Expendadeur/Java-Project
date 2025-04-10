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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EXPENDATEUR
 */
public class Historique extends javax.swing.JPanel {
private RepositoryDetailCourier repository;
    public Historique() {
        initComponents();
         repository=new RepositoryDetailCourier();
         afficherHistoriqueEnvoie();
         afficherHistoriqueRecu();
    }

public void afficherHistoriqueRecu() {
    List<CourrierDetails> historique = repository.readCourriersRecus();
    // Mettez à jour votre JTable ou vos composants UI avec les données récupérées
    // Par exemple :
    DefaultTableModel tableModel = (DefaultTableModel) recu.getModel();
    tableModel.setRowCount(0); // Vider le tableau

    for (CourrierDetails details : historique) {
        Courrier courrier = details.getCourrier();
        Deposant deposant = details.getDeposant();
        Destinataire destinataire = details.getDestinataire();

        Object[] rowData = {
            courrier.getOrigineCourrier(),
            courrier.getDestinationCourrier(),
            courrier.getPoidsCourrier(),
            courrier.getTypeCourrier(),
            courrier.getDateRecu(),
            courrier.getMontantPaye(),
            deposant.getNomDeposant(),
            deposant.getPrenomDeposant(),
            destinataire.getNom(),
            destinataire.getPrenom()
        };
        tableModel.addRow(rowData);
    }
}

public void afficherHistoriqueEnvoie() {
    List<CourrierDetails> historique = repository.readCourriersEnvoyes();
    // Mettez à jour votre JTable ou vos composants UI avec les données récupérées
    // Par exemple :
    DefaultTableModel tableModel = (DefaultTableModel) envoie.getModel();
    tableModel.setRowCount(0); // Vider le tableau

    for (CourrierDetails details : historique) {
        Courrier courrier = details.getCourrier();
        Deposant deposant = details.getDeposant();
        Destinataire destinataire = details.getDestinataire();

        Object[] rowData = {
            courrier.getOrigineCourrier(),
            courrier.getDestinationCourrier(),
            courrier.getPoidsCourrier(),
            courrier.getTypeCourrier(),
            courrier.getDateEnvoi(),
            courrier.getMontantPaye(),
            deposant.getNomDeposant(),
            deposant.getPrenomDeposant(),
            destinataire.getNom(),
            destinataire.getPrenom()
        };
        tableModel.addRow(rowData);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        envoie = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recu = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(122, 112, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(1158, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HISTORIQUE DES COURRIERS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel1)
                .addContainerGap(721, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(660, 600));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("HISTORIQUE DES COURRIERS ENVOIES");

        envoie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORIGINE", "DESTINATION", "POIDS", "TYPE", "DATE ENVOIE", "MONTANT", "NOM E", "PRENOM E", "NOM D", "PRENOM D"
            }
        ));
        jScrollPane2.setViewportView(envoie);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.LINE_START);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("HISTORIQUE DES COURRIERS DISTRIBUES");

        recu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORIGINE", "DESTINATION", "POIDS", "TYPE", "DATE RECEPTION", "MONTANT", "EXPEDITEUR", "DESTINATEUR"
            }
        ));
        jScrollPane1.setViewportView(recu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable envoie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recu;
    // End of variables declaration//GEN-END:variables
}
