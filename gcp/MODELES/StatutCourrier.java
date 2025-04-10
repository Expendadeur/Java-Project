/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class StatutCourrier {
     private int idStatut;
    private int idCourrier;
    private String statut;
    private String dateMiseAJour;

    public StatutCourrier(int idStatut, int idCourrier, String statut, String dateMiseAJour) {
        this.idStatut = idStatut;
        this.idCourrier = idCourrier;
        this.statut = statut;
        this.dateMiseAJour = dateMiseAJour;
    }

    public int getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public int getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(int idCourrier) {
        this.idCourrier = idCourrier;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(String dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }
    
    
}
