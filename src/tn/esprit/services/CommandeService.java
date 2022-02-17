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
        String req = "INSERT INTO `commande` (`client`, `productID`, `quantite`) VALUES ('"+ p.getClient() +"','"+ p.getProductID() +"','"+ p.getQuantite()+"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("commande ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void ajouterCmd(Commande p){
        String req = "INSERT INTO `commande` (`client`, `productID`, `quantite`) VALUES (?,?,?)";
        
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, p.getClient());
            pst.setInt(2, p.getProductID());
            pst.setInt(3, p.getQuantite());            
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
                c.setProductID(rs.getInt(3));
                c.setQuantite(rs.getInt(4));
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

    @Override
    public void modifier(Commande entity, int id) {
            String req = "UPDATE `commande` SET `client`='"+ entity.getClient()+"' ,`productID`='"+ entity.getProductID()+"',`quantite`='"+ entity.getQuantite() +"' WHERE orderID=" + id +";";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("commande modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}