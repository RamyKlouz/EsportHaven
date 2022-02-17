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

    public String getNom() {
        return Nom_Sponsor;
    }

    public void setNom(String Nom) {
        this.Nom_Sponsor = Nom;
    }

    public String getPrenom() {
        return Prenom_Sponsor;
    }

    public void setPrenom(String Prenom) {
        this.Prenom_Sponsor = Prenom;
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
        return "Sponsors{" + "ID_Sponsor=" + ID_Sponsor + ", Nom=" + Nom_Sponsor + ", Prenom=" + Prenom_Sponsor + ", Montant=" + Montant + ", Duree_spons=" + Duree_spons + '}';
    }
    
    
}
