/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class PosteBoiteDetails {
    private Poste poste;
    private BoitePostale boitePostale;

    public PosteBoiteDetails(Poste poste, BoitePostale boitePostale) {
        this.poste = poste;
        this.boitePostale = boitePostale;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public BoitePostale getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(BoitePostale boitePostale) {
        this.boitePostale = boitePostale;
    }
    
    
    
}
