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
import tn.esprit.services.CommandeService;
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
        Produit p = new Produit("pull rouge","Nike","vetement",40);
        Produit g = new Produit("pull orange","Adidas","vetement",30);
        Commande c = new Commande("Taher",3,10);
        Commande c2 = new Commande("Maher",5,20);
        //ps.modifier(g, 5);
        //ps.ajouterPst(p);
        //System.out.println( ps.afficher() );
        //ps.supprimer(9);
        
        //ps.ajouterPst(p); 
        
       //cs.modifier(c2,8);
       //cs.ajouterCmd(c);
       cs.supprimer(10);
       // System.out.println( ps.afficher() );
       //System.out.println(cs.afficher());
    }
    
}
