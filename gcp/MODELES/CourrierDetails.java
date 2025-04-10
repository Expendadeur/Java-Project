/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class CourrierDetails {
    private Courrier courrier;
    private Deposant deposant;
    private Destinataire destinataire;

    public CourrierDetails(Courrier courrier, Deposant deposant, Destinataire destinataire) {
        this.courrier = courrier;
        this.deposant = deposant;
        this.destinataire = destinataire;
    }

    public Courrier getCourrier() {
        return courrier;
    }

    public void setCourrier(Courrier courrier) {
        this.courrier = courrier;
    }

    public Deposant getDeposant() {
        return deposant;
    }

    public void setDeposant(Deposant deposant) {
        this.deposant = deposant;
    }

    public Destinataire getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Destinataire destinataire) {
        this.destinataire = destinataire;
    }
    
    
}
