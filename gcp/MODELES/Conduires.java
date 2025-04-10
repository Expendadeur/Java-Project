/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Conduires {
    private Employe employe;
    private Automobile automobile;
    private String heureDepart;
    private String heureRetour;

    public Conduires(Employe employe, Automobile automobile, String heureDepart, String heureRetour) {
        this.employe = employe;
        this.automobile = automobile;
        this.heureDepart = heureDepart;
        this.heureRetour = heureRetour;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureRetour() {
        return heureRetour;
    }
}
