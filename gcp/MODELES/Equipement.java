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
public class Equipement {
     private int idEquipement;
    private String nomEquipement;
    private String typeEquipement;
    private Date dateAchat;
    private String etat;

    public Equipement(String nomEquipement, String typeEquipement, Date dateAchat, String etat) {
        this.nomEquipement = nomEquipement;
        this.typeEquipement = typeEquipement;
        this.dateAchat = dateAchat;
        this.etat = etat;
    }

    public Equipement( String nomEquipement, String typeEquipement, Date dateAchat, String etat,int idEquipement) {
        this.idEquipement = idEquipement;
        this.nomEquipement = nomEquipement;
        this.typeEquipement = typeEquipement;
        this.dateAchat = dateAchat;
        this.etat = etat;
    }

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public String getNomEquipement() {
        return nomEquipement;
    }

    public void setNomEquipement(String nomEquipement) {
        this.nomEquipement = nomEquipement;
    }

    public String getTypeEquipement() {
        return typeEquipement;
    }

    public void setTypeEquipement(String typeEquipement) {
        this.typeEquipement = typeEquipement;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
}
