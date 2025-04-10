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
public class Employe {
    private int idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String matricule;
    private Date dateNaiss;
    private Date dateEmb;
    private String numTel;
    private String pswd;
    private String login;
    private int idService;
    private int idAgence;
    private String role;

    public Employe(String nomEmploye, String prenomEmploye, String matricule, Date dateNaiss, Date dateEmb, String numTel, String pswd, String login, int idService, int idAgence,String role) {
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.matricule = matricule;
        this.dateNaiss = dateNaiss;
        this.dateEmb = dateEmb;
        this.numTel = numTel;
        this.pswd = pswd;
        this.login = login;
        this.idService = idService;
        this.idAgence = idAgence;
        this.role=role;
    }

    public Employe( String nomEmploye, String prenomEmploye, String matricule, Date dateNaiss, Date dateEmb, String numTel, String pswd, String login, int idService, int idAgence,int idEmploye) {
        this.idEmploye = idEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.matricule = matricule;
        this.dateNaiss = dateNaiss;
        this.dateEmb = dateEmb;
        this.numTel = numTel;
        this.pswd = pswd;
        this.login = login;
        this.idService = idService;
        this.idAgence = idAgence;
    }



    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Date getDateEmb() {
        return dateEmb;
    }

    public void setDateEmb(Date dateEmb) {
        this.dateEmb = dateEmb;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    
    
    
    
}
