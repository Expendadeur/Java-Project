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
public class Tarifications {
    private int idTarif;
    private String typeCourrier;
    private double tarif;
    private Date dateValidite;

    public Tarifications(String typeCourrier, double tarif, Date dateValidite) {
        this.typeCourrier = typeCourrier;
        this.tarif = tarif;
        this.dateValidite = dateValidite;
    }

    public Tarifications(String typeCourrier, double tarif, Date dateValidite,int idTarif) {
        this.idTarif = idTarif;
        this.typeCourrier = typeCourrier;
        this.tarif = tarif;
        this.dateValidite = dateValidite;
    }

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }

    public String getTypeCourrier() {
        return typeCourrier;
    }

    public void setTypeCourrier(String typeCourrier) {
        this.typeCourrier = typeCourrier;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Date getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Date dateValidite) {
        this.dateValidite = dateValidite;
    }
    
    
}
