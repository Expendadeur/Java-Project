/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Ville {
     private int idVille;
    private String groupeVille;
    private String nomVille;

    public Ville(int idVille, String groupeVille, String nomVille) {
        this.idVille = idVille;
        this.groupeVille = groupeVille;
        this.nomVille = nomVille;
    }

    public Ville(String groupeVille, String nomVille) {
        this.groupeVille = groupeVille;
        this.nomVille = nomVille;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getGroupeVille() {
        return groupeVille;
    }

    public void setGroupeVille(String groupeVille) {
        this.groupeVille = groupeVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }
    
    
}
