/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.tests;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.Clock;
import tn.esports.entities.Partie;
import tn.esports.entities.Tournois;
import tn.esports.services.PartieService;
import tn.esports.services.TournoisService;
import tn.esports.utils.DataSource;
/**
 *
 * @author ASUS
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        TournoisService ts = new TournoisService(); 
        //Tournois tour = new Tournois("second", 2022/02/28, 2022/03/02, 10, "candy");
        //ts.ajouter(tour);
        PartieService ps= new PartieService();
        
        
        PartieService  part_serv = new PartieService();
        //ps.suppPartie(1);
        
        Partie p = new Partie(2, 30, "1-1" , Date.valueOf("2022-02-17") , 1);
        ps.modifierPartie(p);
        //Tournois t = new Tournois(1,"islem",new Date(2022, 02, 22), new Date(2022, 02, 23),6,"COD" );
        System.out.println(ts.afficher());
        System.out.println(ps.affichPartie());
        //t.setId(1);
        //ts.modifier(t);
//        Partie partie = new Partie();
//        partie.setDuree(13);
//        partie.setIdTournois(1);
//        partie.setScore("NULL");
//        partie.setDate_deroul(new Date(2022, 02, 17));
//        
//        
//        part_serv.ajouterPartie(partie);

     /* Tournois tr = new Tournois();
       tr.setDate_deb(new Date(2022, 02, 17));
       tr.setDate_fin(new Date(2022, 02, 23));
       tr.setJeux("VALORANT");
       tr.setNb_equipes(10);
       tr.setNom("Tournois Valorant Forset el 3mor prix 5 DT"); */
        
        
       //ps.modifier(tr); 
        
      // System.out.println(tr.afficher()  );
        
        //SUPPRIMER TOURNOIS
       // ps.supprimer(2);
      
       // Partie p =new Partie();
        //p.setDuree(30);
        //p.setDate_deroul(new Date(2022, 02, 26));
      //  System.out.println( tr.afficher() );
                
        
         
                
                
                
    }
    
}

