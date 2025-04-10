/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Depeche {
     private String idDepeche;
    private double poidsDepeche;
    private String origineDepeche;
    private String destinationDepeche;
    private String description;

    public Depeche(String idDepeche, double poidsDepeche, String origineDepeche, String destinationDepeche, String description) {
        this.idDepeche = idDepeche;
        this.poidsDepeche = poidsDepeche;
        this.origineDepeche = origineDepeche;
        this.destinationDepeche = destinationDepeche;
        this.description = description;
    }

    public Depeche(double poidsDepeche, String origineDepeche, String destinationDepeche, String description) {
        this.poidsDepeche = poidsDepeche;
        this.origineDepeche = origineDepeche;
        this.destinationDepeche = destinationDepeche;
        this.description = description;
    }

    public String getIdDepeche() {
        return idDepeche;
    }

    public void setIdDepeche(String idDepeche) {
        this.idDepeche = idDepeche;
    }

    public double getPoidsDepeche() {
        return poidsDepeche;
    }

    public void setPoidsDepeche(double poidsDepeche) {
        this.poidsDepeche = poidsDepeche;
    }

    public String getOrigineDepeche() {
        return origineDepeche;
    }

    public void setOrigineDepeche(String origineDepeche) {
        this.origineDepeche = origineDepeche;
    }

    public String getDestinationDepeche() {
        return destinationDepeche;
    }

    public void setDestinationDepeche(String destinationDepeche) {
        this.destinationDepeche = destinationDepeche;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
