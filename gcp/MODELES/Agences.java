/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

import java.util.regex.Pattern;

/**
 *
 * @author ISSA 2025
 */
public class Agences {
    private int idAgence;
    private String nomAgence;
    private String adresse; // Format : "123 Rue de la Liberté, 75001 Paris"
    private String ville;    // Format : "Paris"
    private String pays;     // Format : "France"
    private String numTel;   // Format : "+33 6 12 34 56 78"

    public Agences(String nomAgence, String adresse, String ville, String pays, String numTel) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.numTel = numTel;
    }

    public Agences(String nomAgence, String adresse, String ville, String pays, String numTel,int idAgence) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.numTel = numTel;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
   
}
