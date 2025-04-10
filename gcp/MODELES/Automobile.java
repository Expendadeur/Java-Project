/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Automobile {
     private int idAutomobile;
    private String numPlaque;
    private String marqueAutomobile;

    public Automobile( String numPlaque, String marqueAutomobile,int idAutomobile) {
        this.idAutomobile = idAutomobile;
        this.numPlaque = numPlaque;
        this.marqueAutomobile = marqueAutomobile;
    }

    public Automobile(String numPlaque, String marqueAutomobile) {
        this.numPlaque = numPlaque;
        this.marqueAutomobile = marqueAutomobile;
    }

    public int getIdAutomobile() {
        return idAutomobile;
    }

    public void setIdAutomobile(int idAutomobile) {
        this.idAutomobile = idAutomobile;
    }

    public String getNumPlaque() {
        return numPlaque;
    }

    public void setNumPlaque(String numPlaque) {
        this.numPlaque = numPlaque;
    }

    public String getMarqueAutomobile() {
        return marqueAutomobile;
    }

    public void setMarqueAutomobile(String marqueAutomobile) {
        this.marqueAutomobile = marqueAutomobile;
    }
    
    
}
