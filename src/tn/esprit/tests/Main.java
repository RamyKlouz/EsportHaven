/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tn.esprit.tests;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import tn.esprit.entities.Produit;
import tn.esprit.services.ProduitService;
import tn.esprit.entities.Commande;
import tn.esprit.entities.CommandeProduit;
import tn.esprit.services.CommandeService;
import tn.esprit.services.CPService;
import tn.esprit.utils.Datasource;

/**
 *
 * @author remo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ProduitService ps = new ProduitService();
        CommandeService cs = new CommandeService();
        CPService cps = new CPService();
        Produit p = new Produit("pull rouge","vetement","Nike",40,6);
        Produit g = new Produit("pull orange","Adidas","vetement",30,10);
        Commande c = new Commande("Taher",0);
        Commande c2 = new Commande("Maher",50);
        CommandeProduit cp1 = new CommandeProduit(41,50,60,14);
        
        //ps.ajouterPst(p);
        //ps.modifier(g, 5);
        //System.out.println( ps.afficher() );
       // System.out.println( ps.RechercheProd("'sdg'") );
        //System.out.println( ps.RechercheProd2(7) );
        //System.out.println( ps.compter("Fnatic") );
        //System.out.println( ps.RechercheProduit(41) );
        //ps.supprimer(9);
        
        cps.ajouter(cp1);
        //cps.supprimer(4);
        System.out.println( cps.afficher() );
        System.out.println( cps.somme() );

       cs.ajouterCmd(c2) ;
       //cs.modifier(c2,8);
       //cs.supprimer(10);
       //System.out.println(cs.afficher());
       //System.out.println(cs.lastid());
       
       
    }
    
}
