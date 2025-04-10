/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Deposant {
    private int idCourrier;
    private int idDeposant;
    private String numIdentite;
    private String adresse;
    private String nomDeposant;
    private String prenomDeposant;
    private String telDeposant;
    private String sexe;
    
    
    
    public Deposant(int idCourrier, int idDeposant, String numIdentite, String adresse, String nomDeposant, String prenomDeposant, String telDeposant, String sexe) {
        this.idCourrier = idCourrier;
        this.idDeposant = idDeposant;
        this.numIdentite = numIdentite;
        this.adresse = adresse;
        this.nomDeposant = nomDeposant;
        this.prenomDeposant = prenomDeposant;
        this.telDeposant = telDeposant;
        this.sexe = sexe;
    }

    public Deposant(String numIdentite, String adresse, String nomDeposant, String prenomDeposant, String telDeposant, String sexe) {
        this.numIdentite = numIdentite;
        this.adresse = adresse;
        this.nomDeposant = nomDeposant;
        this.prenomDeposant = prenomDeposant;
        this.telDeposant = telDeposant;
        this.sexe = sexe;
    }

    public Deposant(int idDeposant, String numIdentite, String adresse, String nomDeposant, String telDeposant, String sexe, String string5) {
        this.idDeposant = idDeposant;
        this.numIdentite = numIdentite;
        this.adresse = adresse;
        this.nomDeposant = nomDeposant;
        this.telDeposant = telDeposant;
        this.sexe = sexe;
    }
    

    public int getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(int idCourrier) {
        this.idCourrier = idCourrier;
    }

    public int getIdDeposant() {
        return idDeposant;
    }

    public void setIdDeposant(int idDeposant) {
        this.idDeposant = idDeposant;
    }

    public String getNumIdentite() {
        return numIdentite;
    }

    public void setNumIdentite(String numIdentite) {
        this.numIdentite = numIdentite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomDeposant() {
        return nomDeposant;
    }

    public void setNomDeposant(String nomDeposant) {
        this.nomDeposant = nomDeposant;
    }

    public String getPrenomDeposant() {
        return prenomDeposant;
    }

    public void setPrenomDeposant(String prenomDeposant) {
        this.prenomDeposant = prenomDeposant;
    }

    public String getTelDeposant() {
        return telDeposant;
    }

    public void setTelDeposant(String telDeposant) {
        this.telDeposant = telDeposant;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    
}
