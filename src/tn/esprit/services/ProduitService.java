/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.entities.IService;
import tn.esprit.entities.Produit;
import tn.esprit.utils.Datasource;
/**
 *
 * @author remo
 */
public class ProduitService implements IService<Produit>{
    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public ProduitService() {
        conn = Datasource.getInstance().getCnx();
    }
    
  //  @Override
    public void ajouter(Produit p){
        String req = "INSERT INTO `produit` (`nom`, `marque`, `type`, `quantite`) VALUES ('"+ p.getNom() +"','"+ p.getMarque() +"','"+ p.getType()+ "','"+ p.getQuantite() +"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("produit ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void ajouterPst(Produit p){
        String req = "INSERT INTO `produit` (`nom`, `type`, `marque`, `quantite`) VALUES (?,?,?,?)";
        
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getMarque());
            pst.setString(3, p.getType());            
            pst.setInt(4, p.getQuantite());
            pst.executeUpdate();
            System.out.println("produit ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Produit> afficher(){
        List<Produit> produits = new ArrayList<>();
        
        String req = "SELECT * from `produit`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Produit p = new Produit();
                p.setId( rs.getInt("productID") );
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(3));
                p.setType(rs.getString(4));
                p.setQuantite(rs.getInt(5));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return produits;
    }

    @Override
    public void supprimer(int id) {
        String req = "DELETE From produit WHERE productID =" + id + ";";
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("produit supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Produit p, int id) {
        String req = "UPDATE `produit` SET `nom`='"+ p.getNom() +"' ,`marque`='"+ p.getMarque() +"',`type`='"+ p.getType() +"',`quantite`='"+ p.getQuantite() +"' WHERE productID=" + id +";";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("produit modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       
    }
   
  
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


