/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Poste {
     private String nomPoste;
    private String regime;
    private String pays;
    private String ville;
    private int IdPoste;

    public Poste(String nomPoste, String regime, String pays, String ville) {
        this.nomPoste = nomPoste;
        this.regime = regime;
        this.pays = pays;
        this.ville = ville;
    }

    public Poste(String nomPoste, String regime, String pays, String ville, int IdPoste) {
        this.nomPoste = nomPoste;
        this.regime = regime;
        this.pays = pays;
        this.ville = ville;
        this.IdPoste = IdPoste;
    }

    public int getIdPoste() {
        return IdPoste;
    }

    public void setIdPoste(int IdPoste) {
        this.IdPoste = IdPoste;
    }
    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
      
}
