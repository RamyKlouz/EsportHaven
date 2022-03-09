/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Partie {
    
    private int idPartie;
    private float duree;
    private int score1;
    private int score2;
    private Date date_deroul;
    private int id_tournoi;
    private int id_equipe1;
    private int id_equipe2;

    public Partie() {
    }


    public Partie(int idPartie, float duree, int score1, int score2, Date date_deroul, int id_tournoi, int id_equipe1) {
        this.idPartie = idPartie;
        this.duree = duree;
        this.score1 = score1;
        this.score2 = score2;
        this.date_deroul = date_deroul;
        this.id_tournoi = id_tournoi;
        this.id_equipe1 = id_equipe1;
    }

    public Partie(int idPartie, float duree, int score1, int score2, Date date_deroul, int id_tournoi, int id_equipe1, int id_equipe2) {
        this.idPartie = idPartie;
        this.duree = duree;
        this.score1 = score1;
        this.score2 = score2;
        this.date_deroul = date_deroul;
        this.id_tournoi = id_tournoi;
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
    }

    public Partie(float duree, int score1, int score2, Date date_deroul, int id_tournoi, int id_equipe1, int id_equipe2) {
        this.duree = duree;
        this.score1 = score1;
        this.score2 = score2;
        this.date_deroul = date_deroul;
        this.id_tournoi = id_tournoi;
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
    }

    public Partie(float duree, int score1, int score2, Date date_deroul) {
        this.duree = duree;
        this.score1 = score1;
        this.score2 = score2;
        this.date_deroul = date_deroul;
    }

  
    
   

  
    
   

    public int getIdPartie() {
        return idPartie;
    }

    public float getDuree() {
        return duree;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

 

    public Date getDate_deroul() {
        return date_deroul;
    }


    

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

   

    public void setDate_deroul(Date date_deroul) {
        this.date_deroul = date_deroul;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public int getId_equipe1() {
        return id_equipe1;
    }

    public int getId_equipe2() {
        return id_equipe2;
    }

    public void setId_equipe1(int id_equipe1) {
        this.id_equipe1 = id_equipe1;
    }

    public void setId_equipe2(int id_equipe2) {
        this.id_equipe2 = id_equipe2;
    }

    @Override
    public String toString() {
        return "Partie{" + "idPartie=" + idPartie + ", duree=" + duree + ", score1=" + score1 + ", score2=" + score2 + ", date_deroul=" + date_deroul + ", id_tournoi=" + id_tournoi + ", id_equipe1=" + id_equipe1 + ", id_equipe2=" + id_equipe2 + '}';
    }

   

    

   

  
   
    
    
}
