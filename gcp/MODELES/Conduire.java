/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Conduire {
     private int idConduire;
    private int idEmploye;
    private int idAutomobile;
    private String heureDepart;
    private String heureRetour;

    public Conduire(int idConduire, int idEmploye, int idAutomobile, String heureDepart, String heureRetour) {
        this.idConduire = idConduire;
        this.idEmploye = idEmploye;
        this.idAutomobile = idAutomobile;
        this.heureDepart = heureDepart;
        this.heureRetour = heureRetour;
    }

    public Conduire(int idEmploye, int idAutomobile, String heureDepart, String heureRetour) {
        this.idEmploye = idEmploye;
        this.idAutomobile = idAutomobile;
        this.heureDepart = heureDepart;
        this.heureRetour = heureRetour;
    }

    public int getIdConduire() {
        return idConduire;
    }

    public void setIdConduire(int idConduire) {
        this.idConduire = idConduire;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public int getIdAutomobile() {
        return idAutomobile;
    }

    public void setIdAutomobile(int idAutomobile) {
        this.idAutomobile = idAutomobile;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureRetour() {
        return heureRetour;
    }

    public void setHeureRetour(String heureRetour) {
        this.heureRetour = heureRetour;
    }

    public Object getEmploye() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
