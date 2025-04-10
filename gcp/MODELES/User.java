/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author EXPENDATEUR
 */
public class User {
    private String nom;
    private String prenom;
    private String role;
    private int agenceId;

    public User(String nom, String prenom, String role, int agenceId) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.agenceId = agenceId;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getRole() { return role; }
    public int getAgenceId() { return agenceId; }
}
