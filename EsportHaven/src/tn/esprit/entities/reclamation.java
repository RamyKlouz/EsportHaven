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

    public reclamation(int id, String description) {
        this.id = id;

        this.description = description;
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

   

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
