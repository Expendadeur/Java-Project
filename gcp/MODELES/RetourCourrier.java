/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class RetourCourrier {
     private int idRetour;
    private int idCourrier;
    private String raisonRetour;
    private String dateRetour;

    public RetourCourrier(int idRetour, int idCourrier, String raisonRetour, String dateRetour) {
        this.idRetour = idRetour;
        this.idCourrier = idCourrier;
        this.raisonRetour = raisonRetour;
        this.dateRetour = dateRetour;
    }

    public int getIdRetour() {
        return idRetour;
    }

    public void setIdRetour(int idRetour) {
        this.idRetour = idRetour;
    }

    public int getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(int idCourrier) {
        this.idCourrier = idCourrier;
    }

    public String getRaisonRetour() {
        return raisonRetour;
    }

    public void setRaisonRetour(String raisonRetour) {
        this.raisonRetour = raisonRetour;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }
    
    
}
