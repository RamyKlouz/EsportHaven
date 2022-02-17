/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.entities;
import java.sql.Date;
/**
 *
 * @author ASUS
 */
public class Tournois {
    private int id;
    private String nom;
    private Date date_deb;
    private Date date_fin;
    private int nb_equipes;
    private String jeux;
    public Tournois() {
    }

    public Tournois(int id, String nom, Date date_deb, Date date_fin, int nb_equipes, String jeux) {
        this.id = id;
        this.nom = nom;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.nb_equipes = nb_equipes;
        //this.partie = partie;
        this.jeux = jeux;
    }

    public Tournois(String nom, Date date_deb, Date date_fin, int nb_equipes, String jeux) {
        this.nom = nom;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.nb_equipes = nb_equipes;
        this.jeux = jeux;
    }

 

 

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public int getNb_equipes() {
        return nb_equipes;
    }

//    public String[] getPartie() {
//        return partie;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJeux() {
        return jeux;
    }

    public void setJeux(String jeux) {
        this.jeux = jeux;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setNb_equipes(int nb_equipes) {
        this.nb_equipes = nb_equipes;
    }

//    public void setPartie(String[] partie) {
//        this.partie = partie;
//    }

    @Override
    public String toString() {
        return "Tournois{" + "id=" + id + ", nom=" + nom + ", date_deb=" + date_deb + ", date_fin=" + date_fin + ", nb_equipes=" + nb_equipes + /* ", partie=" + partie + */", jeux=" + jeux + '}';
    }

    
    
}
