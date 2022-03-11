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
import tn.esprit.entities.CommandeProduit;
import tn.esprit.entities.IService;
import tn.esprit.entities.Produit;
import tn.esprit.utils.Datasource;

/**
 *
 * @author ramyc
 */
public class CPService implements IService<CommandeProduit>{
    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public CPService() {
        conn = Datasource.getInstance().getCnx();
    }
    
   
    
    public void ajouter(CommandeProduit p){
        String req = "INSERT INTO `commandeproduit` (`productID`, `quantite`,`sommePrix`,`orderID`) VALUES (?,?,?,?)";
        
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, p.getProductID());
            
            pst.setInt(2, p.getQuantite());   
            pst.setInt(3, p.getSommePrix());  
            pst.setInt(4, p.getOrderID());
            pst.executeUpdate();
            System.out.println("CommandeProduit ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    
    @Override
    public List<CommandeProduit> afficher(){
        List<CommandeProduit> commandes = new ArrayList<>();
        
        String req = "SELECT * from `commandeproduit`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                CommandeProduit c = new CommandeProduit();
                c.setCpID(rs.getInt(1) );
                c.setProductID( rs.getInt("productID") );
                c.setQuantite(rs.getInt(3));
                c.setSommePrix(rs.getInt(4));
                c.setOrderID(rs.getInt(5));
                commandes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return commandes;
    }

        public int somme() {
        int result=0;
        List<CommandeProduit> cps = new ArrayList<>();
        String req = "SELECT * from `commandeproduit`";
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                result=result+rs.getInt("sommePrix");
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
    @Override
    public void supprimer(int id) {
        String req = "DELETE From commandeproduit WHERE cpID =" + id + ";";
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("commandeproduit supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public void clear() {
        String req = "DELETE From `commandeproduit` ;";
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("tout est supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    @Override
    public void modifier(CommandeProduit entity, int id) {
            String req = "UPDATE `commandeproduit` SET `productID`='"+ entity.getProductID() +"',`quantite`='"+ entity.getQuantite()+"',`sommePrix`='"+ entity.getSommePrix()+ "' ,`orderID`='"+ entity.getOrderID() +"' WHERE cpID=" + id +";";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("commandeproduit modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}