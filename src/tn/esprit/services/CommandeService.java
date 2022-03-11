/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Commande;
import tn.esprit.entities.IService;
import tn.esprit.entities.Produit;
import tn.esprit.utils.Datasource;

/**
 *
 * @author PDG
 */
public class CommandeService implements IService<Commande>{
    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public CommandeService() {
        conn = Datasource.getInstance().getCnx();
    }
    
  //  @Override
    public void ajouter(Commande p){
        String req = "INSERT INTO `commande` (`client`) VALUES ('"+ p.getClient() +"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("commande ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void ajouterCmd(Commande p){
        String req = "INSERT INTO `commande` (`client`,`somme`) VALUES (?,?)";
        
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, p.getClient());
            pst.setInt(2,p.getSomme());
            pst.executeUpdate();
            System.out.println("Commande ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Commande> afficher(){
        List<Commande> commandes = new ArrayList<>();
        
        String req = "SELECT * from `commande`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Commande c = new Commande();
                c.setOrderID( rs.getInt("orderID") );
                c.setClient(rs.getString(2));
                c.setSomme(rs.getInt(3));
                commandes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return commandes;
    }

    @Override
    public void supprimer(int id) {
        String req = "DELETE From commande WHERE orderID =" + id + ";";
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("commande supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int lastid() {
        int result = -1;
        String req = "SELECT * FROM commande WHERE orderID = (SELECT MAX(orderID) FROM commande)";
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
            result = rs.getInt(1);}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
        public Commande RechercheCommande(int i) {
       Commande p = new Commande();

        String req = "SELECT * from `commande` WHERE `orderID` LIKE " + i;

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                p.setOrderID(rs.getInt(1));
                p.setClient(rs.getString(2));
                p.setSomme(rs.getInt(3));
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }
    
    @Override
    public void modifier(Commande entity, int id) {
            String req = "UPDATE `commande` SET `client`='"+ entity.getClient()+"',`somme`='"+entity.getSomme()+"` WHERE orderID=" + id +";";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("commande modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}