/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;
//import com.mysql.cj.jdbc.PreparedStatementWrapper;
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
        String req = "INSERT INTO `produit` (`nom`, `marque`, `type`, `quantite`,`prix`) VALUES ('"+ p.getNom() +"','"+ p.getMarque() +"','"+ p.getType()+ "','"+ p.getQuantite() + "','"+ p.getPrix() +"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("produit ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void ajouterPst(Produit p) {
        String req = "INSERT INTO `produit` (`nom`, `type`, `marque`, `quantite`,`prix`) VALUES (?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getType());
            pst.setString(3, p.getMarque());

            pst.setInt(4, p.getQuantite());
            pst.setInt(5, p.getPrix());
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
                p.setProductId( rs.getInt("productID") );
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt(5));
                p.setPrix(rs.getInt(6));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return produits;
    }
    
    public List<Produit> afficherObs(){
        List<Produit> produits = new ArrayList<>();
        
        String req = "SELECT * from `produit`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Produit p = new Produit();
                p.setProductId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getInt(6));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return produits;
    }
    public List<Produit> RechercheProd(String S) {
        List<Produit> produits = new ArrayList<>();

        String req = "SELECT * from `produit` WHERE `nom` LIKE " + S;

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produit p = new Produit();
                p.setProductId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getInt(6));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return produits;
    }
        public List<Produit> RechercheProdId(int s) {
        List<Produit> produits = new ArrayList<>();

        String req = "SELECT * from `produit` WHERE `productID` LIKE " + s;

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produit p = new Produit();
                p.setProductId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getInt(6));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return produits;
    }
    
    public List<Produit> RechercheProd2(int prix) {
        List<Produit> produits = new ArrayList<>();

        String req = "SELECT * from `produit` WHERE `prix` < " + prix;

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produit p = new Produit();
                p.setProductId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getInt(6));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return produits;
    }
    
    public Produit RechercheProduit(int i) {
        List<Produit> produits = new ArrayList<>();

        String req = "SELECT * from `produit` WHERE `productID` LIKE " + i;

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produit p = new Produit();
                p.setProductId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getInt(6));
                produits.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return produits.get(0);
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

    public int compter(String S) {
        int result=0;
        List<Produit> produits = new ArrayList<>();
        String req = "SELECT * from `produit` WHERE marque= '"+S+"'";
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Produit p = new Produit();
                p.setProductId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setMarque(rs.getString(4));
                p.setType(rs.getString(3));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getInt(6));
                produits.add(p);
                result++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public void modifier(Produit p, int id) {
        String req = "UPDATE `produit` SET `nom`='"+ p.getNom()+"',`type`='"+ p.getType() +"' ,`marque`='"+ p.getMarque()  +"',`quantite`='"+ p.getQuantite()+"',`prix`='"+ p.getPrix() +"' WHERE productID=" + id +";";
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


