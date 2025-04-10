/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Traitement {
     private int idTraitement;
    private int idEmploye;
    private String dateTraitement;

    public Traitement(int idTraitement, int idEmploye, String dateTraitement) {
        this.idTraitement = idTraitement;
        this.idEmploye = idEmploye;
        this.dateTraitement = dateTraitement;
    }

    public int getIdTraitement() {
        return idTraitement;
    }

    public void setIdTraitement(int idTraitement) {
        this.idTraitement = idTraitement;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(String dateTraitement) {
        this.dateTraitement = dateTraitement;
    }
    
    
    
}
