/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Route {
    private int idRoute;
    private String nomRoute;
    private String villeDepart;
    private String villeEscale;
    private String villeArrivee;

    public Route(String nomRoute, String villeDepart, String villeEscale, String villeArrivee,int idRoute) {
        this.idRoute = idRoute;
        this.nomRoute = nomRoute;
        this.villeDepart = villeDepart;
        this.villeEscale = villeEscale;
        this.villeArrivee = villeArrivee;
    }

    public Route(String nomRoute, String villeDepart, String villeEscale, String villeArrivee) {
        this.nomRoute = nomRoute;
        this.villeDepart = villeDepart;
        this.villeEscale = villeEscale;
        this.villeArrivee = villeArrivee;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public String getNomRoute() {
        return nomRoute;
    }

    public void setNomRoute(String nomRoute) {
        this.nomRoute = nomRoute;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleEscale() {
        return villeEscale;
    }

    public void setVilleEscale(String villeEscale) {
        this.villeEscale = villeEscale;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }
    
    
}
