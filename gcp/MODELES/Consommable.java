/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

import java.util.Date;

/**
 *
 * @author ISSA 2025
 */
public class Consommable {
     private int idConsommable;
    private String nomConsommable;
    private int quantite;
    private String dateAchat;

    public Consommable(String nomConsommable, int quantite, String dateAchat) {
        this.nomConsommable = nomConsommable;
        this.quantite = quantite;
        this.dateAchat = dateAchat;
    }

    public Consommable( String nomConsommable, int quantite, String dateAchat,int idConsommable) {
        this.idConsommable = idConsommable;
        this.nomConsommable = nomConsommable;
        this.quantite = quantite;
        this.dateAchat = dateAchat;
    }

    public int getIdConsommable() {
        return idConsommable;
    }

    public void setIdConsommable(int idConsommable) {
        this.idConsommable = idConsommable;
    }

    public String getNomConsommable() {
        return nomConsommable;
    }

    public void setNomConsommable(String nomConsommable) {
        this.nomConsommable = nomConsommable;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }
    
    
}
