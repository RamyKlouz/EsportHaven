/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import entities.utilisateur;
import java.io.IOException;

import services.UtilisateurService;


/**
 *
 * @author 21654
 */
public class Main {
     /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int x=0;
        String login = "" ;
        String email = "";
        utilisateur u = new utilisateur(x,login, "bachor7", "bachir5", "mejri", email, 55, "tunis", "admin",Boolean.FALSE,Boolean.FALSE);
        UtilisateurService utilisateurService = new UtilisateurService();
        //utilisateurService.ajouterPst(u);
        //utilisateurService.supprimer(6);
        //utilisateurService.modifier("admin",1);
        //utilisateurService.authentifier("bachir4","mmm");
        //utilisateurService.crypt("bachir");
        //utilisateurService.decode("YmFjaGly");
        //utilisateurService.cration_compte(u,"bachir3","test2@gmail.com");
        //utilisateurService.banned(4);
        //utilisateurService.debanner(5);
        //utilisateurService.desactiver(5);
        //utilisateurService.reactiver(5);
       //utilisateurService.envoyer("ahmedbachir.mejri@esprit.tn");




// utilisateur p = new utilisateur();
         //utilisateurService.afficher().forEach( us ->  System.out.println(us.toString()));

        //System.out.println( u.toString());
        
    }
    
    
}
