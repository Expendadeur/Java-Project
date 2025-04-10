/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Compagnie {
      private int idCompagnie;
    private String sigleCompagnie;
    private String nomCompagnie;

    public Compagnie(String sigleCompagnie, String nomCompagnie,int idCompagnie) {
        this.idCompagnie = idCompagnie;
        this.sigleCompagnie = sigleCompagnie;
        this.nomCompagnie = nomCompagnie;
    }

    public Compagnie(String sigleCompagnie, String nomCompagnie) {
        this.sigleCompagnie = sigleCompagnie;
        this.nomCompagnie = nomCompagnie;
    }

    public int getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(int idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public String getSigleCompagnie() {
        return sigleCompagnie;
    }

    public void setSigleCompagnie(String sigleCompagnie) {
        this.sigleCompagnie = sigleCompagnie;
    }

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public void setNomCompagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
    }
    
    
    
}
