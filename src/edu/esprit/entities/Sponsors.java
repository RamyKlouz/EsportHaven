/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author sk4nd
 */
public class Sponsors {
    
    private int ID_Sponsor;
    private String Nom_Sponsor;
    private String Prenom_Sponsor;
    private int Montant;
    private int Duree_spons;

    public Sponsors(int ID_Sponsor) {
        this.ID_Sponsor = ID_Sponsor;
    }

    public Sponsors() {
    }
    
    public Sponsors(int ID_Sponsor, String Nom, String Prenom, int Montant, int Duree_spons) {
        this.ID_Sponsor = ID_Sponsor;
        this.Nom_Sponsor = Nom;
        this.Prenom_Sponsor = Prenom;
        this.Montant = Montant;
        this.Duree_spons = Duree_spons;
    }

    public Sponsors(String Nom, String Prenom, int Montant, int Duree_spons) {
        this.Nom_Sponsor = Nom;
        this.Prenom_Sponsor = Prenom;
        this.Montant = Montant;
        this.Duree_spons = Duree_spons;
    }

    public int getID_Sponsor() {
        return ID_Sponsor;
    }

    public void setID_Sponsor(int ID_Sponsor) {
        this.ID_Sponsor = ID_Sponsor;
    }

 

    public String getNom_Sponsor() {
        return Nom_Sponsor;
    }

    public void setNom_Sponsor(String Nom_Sponsor) {
        this.Nom_Sponsor = Nom_Sponsor;
    }

    public String getPrenom_Sponsor() {
        return Prenom_Sponsor;
    }

    public void setPrenom_Sponsor(String Prenom_Sponsor) {
        this.Prenom_Sponsor = Prenom_Sponsor;
    }

   

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }

    public int getDuree_spons() {
        return Duree_spons;
    }

    public void setDuree_spons(int Duree_spons) {
        this.Duree_spons = Duree_spons;
    }

    @Override
    public String toString() {
        return "" + ID_Sponsor  ;
    }
    
    
}
