/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.MODELES;

import java.util.Date;

/**
 *
 * @author ISSA 2025
 */
public class Courrier {
   private int idCourrier;
    private String origineCourrier;
    private String destinationCourrier;
    private int poidsCourrier;
    private String typeCourrier;
    private Date dateEnvoi;
    private Date dateRecu;
    private String descriptionCourrier;
    private double montantPaye;
    private String statut;
    private int idAgenceOrigine; // Ajoutez ce champ
    private int idAgenceDestination; // Ajoutez ce champ

    public Courrier(String origineCourrier, String destinationCourrier, int poidsCourrier, String typeCourrier, Date dateEnvoi, Date dateRecu, String descriptionCourrier, double montantPaye,String statut,int idAgenceOrigine,int idAgenceDestination) {
        this.origineCourrier = origineCourrier;
        this.destinationCourrier = destinationCourrier;
        this.poidsCourrier = poidsCourrier;
        this.typeCourrier = typeCourrier;
        this.dateEnvoi = dateEnvoi;
        this.dateRecu = dateRecu;
        this.descriptionCourrier = descriptionCourrier;
        this.montantPaye = montantPaye;
        this.statut = statut;
        this.idAgenceOrigine=idAgenceOrigine;
        this.idAgenceDestination=idAgenceDestination;
    }
    
    

    public Courrier(int idCourrier, String origineCourrier, String destinationCourrier, int poidsCourrier, String typeCourrier, Date dateEnvoi, Date dateRecu, String descriptionCourrier, double montantPaye, String statut) {
        this.idCourrier = idCourrier;
        this.origineCourrier = origineCourrier;
        this.destinationCourrier = destinationCourrier;
        this.poidsCourrier = poidsCourrier;
        this.typeCourrier = typeCourrier;
        this.dateEnvoi = dateEnvoi;
        this.dateRecu = dateRecu;
        this.descriptionCourrier = descriptionCourrier;
        this.montantPaye = montantPaye;
        this.statut = statut;
    }

    public int getIdCourrier() {
        return idCourrier;
    }

    public void setIdCourrier(int idCourrier) {
        this.idCourrier = idCourrier;
    }

    public String getOrigineCourrier() {
        return origineCourrier;
    }

    public void setOrigineCourrier(String origineCourrier) {
        this.origineCourrier = origineCourrier;
    }

    public String getDestinationCourrier() {
        return destinationCourrier;
    }

    public void setDestinationCourrier(String destinationCourrier) {
        this.destinationCourrier = destinationCourrier;
    }

    public int getPoidsCourrier() {
        return poidsCourrier;
    }

    public void setPoidsCourrier(int poidsCourrier) {
        this.poidsCourrier = poidsCourrier;
    }

    public String getTypeCourrier() {
        return typeCourrier;
    }

    public void setTypeCourrier(String typeCourrier) {
        this.typeCourrier = typeCourrier;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Date getDateRecu() {
        return dateRecu;
    }

    public void setDateRecu(Date dateRecu) {
        this.dateRecu = dateRecu;
    }

    public String getDescriptionCourrier() {
        return descriptionCourrier;
    }

    public void setDescriptionCourrier(String descriptionCourrier) {
        this.descriptionCourrier = descriptionCourrier;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getIdAgenceOrigine() {
        return idAgenceOrigine;
    }

    public void setIdAgenceOrigine(int idAgenceOrigine) {
        this.idAgenceOrigine = idAgenceOrigine;
    }

    public int getIdAgenceDestination() {
        return idAgenceDestination;
    }

    public void setIdAgenceDestination(int idAgenceDestination) {
        this.idAgenceDestination = idAgenceDestination;
    }
    
    
}
