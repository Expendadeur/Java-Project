/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Notification {
     private int idNotification;
    private int idCourrier;
    private String message;
    private String dateNotification;
    private String destinataire;

    public Notification(int idNotification, int idCourrier, String message, String dateNotification, String destinataire) {
        this.idNotification = idNotification;
        this.idCourrier = idCourrier;
        this.message = message;
        this.dateNotification = dateNotification;
        this.destinataire = destinataire;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(int idCourrier) {
        this.idCourrier = idCourrier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(String dateNotification) {
        this.dateNotification = dateNotification;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }
    
    
}
