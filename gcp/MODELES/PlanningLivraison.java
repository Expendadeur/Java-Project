/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class PlanningLivraison {
     private int idPlanning;
    private int idEmploye;
    private String dateLivraison;
    private String heureDebut;
    private String heureFin;

    public PlanningLivraison(int idPlanning, int idEmploye, String dateLivraison, String heureDebut, String heureFin) {
        this.idPlanning = idPlanning;
        this.idEmploye = idEmploye;
        this.dateLivraison = dateLivraison;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
    
    
}
