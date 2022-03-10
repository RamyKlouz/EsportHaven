/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tn.esprit.tests;

<<<<<<< HEAD


import java.io.IOException;
import tn.esprit.entities.reclamation;
import tn.esprit.services.ReclamationService;

=======
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import tn.esprit.entities.Personne;
import tn.esprit.services.PersonneService;
import tn.esprit.utils.Datasource;
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca

/**
 *
 * @author remo
 */
public class Main {

    /**
     * @param args the command line arguments
<<<<<<< HEAD
     * @throws java.io.IOException
=======
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
<<<<<<< HEAD
//        ReclamationService pst = new ReclamationService();
//        reclamation p = new reclamation(2,"worked");
//        pst.ajouterReclamation2(p); 
//        
//        System.out.println( pst.listerReclamations() );
=======
        PersonneService ps = new PersonneService();
        Personne p = new Personne("ben foulen 2","foulen 2");
        //ps.ajouterPst(p); 
        
        System.out.println( ps.afficher() );
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
        
    }
    
}
