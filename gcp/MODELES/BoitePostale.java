/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class BoitePostale {
    private int idBP;
    private String numBP;
    private String typeBP;
    private String etatBP;

    public BoitePostale( String numBP, String typeBP, String etatBP) {
       
        this.numBP = numBP;
        this.typeBP = typeBP;
        this.etatBP = etatBP;
    }

    public BoitePostale(String numBP, String typeBP, String etatBP,int idBP) {
        this.idBP = idBP;
        this.numBP = numBP;
        this.typeBP = typeBP;
        this.etatBP = etatBP;
    }
    
    

    public int getIdBP() {
        return idBP;
    }

    public void setIdBP(int idBP) {
        this.idBP = idBP;
    }

    public String getNumBP() {
        return numBP;
    }

    public void setNumBP(String numBP) {
        this.numBP = numBP;
    }

    public String getTypeBP() {
        return typeBP;
    }

    public void setTypeBP(String typeBP) {
        this.typeBP = typeBP;
    }

    public String getEtatBP() {
        return etatBP;
    }

    public void setEtatBP(String etatBP) {
        this.etatBP = etatBP;
    }
    
    
}
