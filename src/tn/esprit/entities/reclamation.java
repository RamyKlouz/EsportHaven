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
<<<<<<< HEAD
    
    private String email;

    public reclamation(int id, String description,String email) {
        this.id = id;

        this.description = description;
        
        this.email = email;
=======

    public reclamation(int id, String description) {
        this.id = id;

        this.description = description;
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
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

<<<<<<< HEAD
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

=======
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
   

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
