/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class HistoriqueTransaction {
     private int idTransaction;
    private int idCourrier;
    private int idEmploye;
    private String dateTransaction;
    private String action;

    public HistoriqueTransaction(int idTransaction, int idCourrier, int idEmploye, String dateTransaction, String action) {
        this.idTransaction = idTransaction;
        this.idCourrier = idCourrier;
        this.idEmploye = idEmploye;
        this.dateTransaction = dateTransaction;
        this.action = action;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(int idCourrier) {
        this.idCourrier = idCourrier;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    
}
