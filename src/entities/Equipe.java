/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */

    public class Equipe {
    private int id;
    private String nom ;
    private String nbrJoueur;

    public Equipe() {
    }


    public Equipe(int id, String nom, String nbrJoueur) {
        this.id = id;
        this.nom = nom;
        this.nbrJoueur = nbrJoueur;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNbrJoueur() {
        return nbrJoueur;
    }

    public void setNbrJoueur(String nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", nom=" + nom + ", nbrJoueur=" + nbrJoueur + '}';
    }

   
}

