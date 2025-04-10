/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class SacInterne {
    private int idSacPetitSac;
    private double poidsSacInterne;
    private String regime;
    private String region;
    private String detailsSacInterne;

    public SacInterne(int idSacPetitSac, double poidsSacInterne,String regime,String region, String detailsSacInterne) {
        this.idSacPetitSac = idSacPetitSac;
        this.poidsSacInterne = poidsSacInterne;
        this.regime = regime;
        this.region = region;
        this.detailsSacInterne = detailsSacInterne;
    }

    public SacInterne(double poidsSacInterne,String regime,String region, String detailsSacInterne) {
        this.poidsSacInterne = poidsSacInterne;
         this.regime = regime;
        this.region = region;
        this.detailsSacInterne = detailsSacInterne;
    }

    public int getIdSacPetitSac() {
        return idSacPetitSac;
    }

    public void setIdSacPetitSac(int idSacPetitSac) {
        this.idSacPetitSac = idSacPetitSac;
    }

    public double getPoidsSacInterne() {
        return poidsSacInterne;
    }

    public void setPoidsSacInterne(double poidsSacInterne) {
        this.poidsSacInterne = poidsSacInterne;
    }

    public String getDetailsSacInterne() {
        return detailsSacInterne;
    }

    public void setDetailsSacInterne(String detailsSacInterne) {
        this.detailsSacInterne = detailsSacInterne;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
}
