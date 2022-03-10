/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author 21654
 */
public class utilisateur {
    private int id ;
    private String login;
    private String mdp;
    private String nom; 
    private String prenom;
    private String email;
    private int numtel;
    private String pays;
    private String role;
    private boolean etat;
    private boolean banne;
    
    

    public utilisateur(int id,String login,String mdp, String nom, String prenom,String email,int numtel,String pays,String role,boolean etat,boolean banne) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
        this.pays = pays;
        this.role = role;
        this.etat = etat;
        this.banne = banne;
    }

    public utilisateur() {
    }

    public utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }
  
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getMdp() {
        return mdp;
    }

    public String setMdp(String mdp) {
        this.mdp = mdp;
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int num_tel) {
        this.numtel = num_tel;
    }
    
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEtat() {
        return etat;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }



    public boolean isBanne() {
        return banne;
    }

    public void setBanne(boolean banne) {
        this.banne = banne;
    }

    @Override
    public String toString() {
        return "utilisateur{" +
                ",id='" + id + '\'' +
                ",login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", num_tel=" + numtel +
                ", pays='" + pays + '\'' +
                ", role='" + role + '\'' +
                ", etat='" + etat + '\'' +
                ", banne='" + banne + '\'' +
                '}';
    }
}
