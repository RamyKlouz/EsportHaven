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
    private int num_tel;
    private String pays;
    private String role;
    
    

    public utilisateur(int id,String login,String mdp, String nom, String prenom,String email,int num_tel,String pays,String role) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_tel = num_tel;
        this.pays = pays;
        this.role = role;
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

    public void setId(int id) {
        this.id = id;
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

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
        return num_tel;
    }

    public void setNumtel(int num_tel) {
        this.num_tel = num_tel;
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

    @Override
    public String toString() {
        return "utilisateur{" +
                ",id='" + id + '\'' +
                ",login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", num_tel=" + num_tel +
                ", pays='" + pays + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
