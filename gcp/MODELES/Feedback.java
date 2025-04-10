/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

/**
 *
 * @author ISSA 2025
 */
public class Feedback {
     private int idFeedback;
    private int idDeposant;
    private String commentaire;
    private int note;
    private String dateFeedback;

    public Feedback(int idFeedback, int idDeposant, String commentaire, int note, String dateFeedback) {
        this.idFeedback = idFeedback;
        this.idDeposant = idDeposant;
        this.commentaire = commentaire;
        this.note = note;
        this.dateFeedback = dateFeedback;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getIdDeposant() {
        return idDeposant;
    }

    public void setIdDeposant(int idDeposant) {
        this.idDeposant = idDeposant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getDateFeedback() {
        return dateFeedback;
    }

    public void setDateFeedback(String dateFeedback) {
        this.dateFeedback = dateFeedback;
    }
    
    
    
}
