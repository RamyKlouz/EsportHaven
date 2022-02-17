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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        utilisateur u = new utilisateur(3,"ramy", "ramy", "ramy", "ramy", "test@gmail.com", 88, "tunis", "co");
        UtilisateurService utilisateurService = new UtilisateurService();
        //utilisateurService.ajouterPst(u);
        //ps.ajouterPst(p);
        //utilisateurService.supprimer();
        //utilisateurService.modifier();

         utilisateurService.afficher().forEach( us ->  System.out.println(us.toString()));

        //System.out.println( u.toString());
        
    }
    
    
}
