/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Destinataire {
    private int idDestinataire;
    private int idCourrierEnvoye;
    private String prenom;
    private String nom;
    private String telephone;
    private String sexe;
    private String adresse;
    private String numIdentite;
    
      public Destinataire(int idDestinataire, int idCourrierEnvoye, String prenom, String nom, String telephone, String sexe, String adresse, String numIdentite) {
        this.idDestinataire = idDestinataire;
        this.idCourrierEnvoye = idCourrierEnvoye;
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.sexe = sexe;
        this.adresse = adresse;
        this.numIdentite = numIdentite;
    }
      
       public Destinataire(String prenom, String nom, String telephone, String sexe, String numIdentite, String adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.sexe = sexe;
        this.numIdentite = numIdentite;
        this.adresse = adresse;   
    }

    public Destinataire(String prenom, String nom, String telephone, String sexe, String numIdentite, String adresse,int idDestinataire) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.sexe = sexe;
        this.numIdentite = numIdentite;
        this.adresse = adresse;
        this.idDestinataire=idDestinataire;
        
    }

    public Destinataire(int idDestinataire, String prenom, String nom, String telephone, String sexe,String numIdentite, String adresse) {
        this.idDestinataire = idDestinataire;
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.sexe = sexe;
        this.numIdentite = numIdentite;
        this.adresse = adresse;
        
    }

  
    public int getIdDestinataire() {
        return idDestinataire;
    }

    public void setIdDestinataire(int idDestinataire) {
        this.idDestinataire = idDestinataire;
    }

    public int getIdCourrierEnvoye() {
        return idCourrierEnvoye;
    }

    public void setIdCourrierEnvoye(int idCourrierEnvoye) {
        this.idCourrierEnvoye = idCourrierEnvoye;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumIdentite() {
        return numIdentite;
    }

    public void setNumIdentite(String numIdentite) {
        this.numIdentite = numIdentite;
    }
    
    
}
