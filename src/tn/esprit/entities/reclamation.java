/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author remo
 */
public class reclamation {
    private int id;
    
    private String description;
    
    private String email;

    public reclamation(int id, String description,String email) {
        this.id = id;

        this.description = description;
        
        this.email = email;
    }

    public reclamation() {
    }

    public reclamation( String description) {
        
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", " +   ", descriprion=" + description + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
