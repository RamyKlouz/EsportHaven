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
public class Partie {
    
    private int idPartie;
    private float duree;
    private String score;
    private Date date_deroul;
    private int idTournois;

    public Partie(float duree, String score, Date date_deroul) {
        this.duree = duree;
        this.score = score;
        this.date_deroul = date_deroul;
    }

   

    public Partie(int idPartie, float duree, String score, Date date_deroul, int idTournois) {
        this.idPartie = idPartie;
        this.duree = duree;
        this.score = score;
        this.date_deroul = date_deroul;
        this.idTournois = idTournois;
    }

    public Partie() {
    }
    
    

    public int getIdPartie() {
        return idPartie;
    }

    public float getDuree() {
        return duree;
    }

    public String getScore() {
        return score;
    }

    public Date getDate_deroul() {
        return date_deroul;
    }

    public int getIdTournois() {
        return idTournois;
    }

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setDate_deroul(Date date_deroul) {
        this.date_deroul = date_deroul;
    }

    public void setIdTournois(int idTournois) {
        this.idTournois = idTournois;
    }

    @Override
    public String toString() {
        return "Partie{" + "idPartie=" + idPartie + ", duree=" + duree + ", score=" + score + ", date_deroul=" + date_deroul + ", idTournois=" + idTournois + '}';
    }
    
    
    
}
