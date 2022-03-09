/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.entities.Sponsors;
import edu.esprit.entities.budget;
import edu.esprit.utils.MyConnexion;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sk4nd
 */
public class BudgetCRUD {
        Connection cnx2;
    
    public BudgetCRUD(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    
    public void ajouterBudget (){
        try {
            String requete = "INSERT INTO budget (Montant,Activite) VALUES (120,'Jeux')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Budget ajoutee avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterBudget2(budget B){
         String requete2 = "INSERT INTO budget (`Montant`,`Activite`, `ID_Sponsor`) VALUES (?,?,?)";
       // String requete2 = "INSERT INTO sponsors (`Montant`,`Activite`) VALUES (?,?)";
        try {
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, B.getMontant());
            pst.setString(2, B.getActivite());
            pst.setInt(3, B.getSponsors().getID_Sponsor());
            pst.executeUpdate();
            System.out.println("Votre budget est ajoute!");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
    
    public List<budget> AfficherBudget(){
        List<budget> myList = new ArrayList<>();
        try {      
            String requete3="SELECT * from budget";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                budget Bd = new budget();
                Bd.setID_Budget(rs.getInt(1));
                Bd.setMontant(rs.getInt(2));
                Bd.setActivite(rs.getString("Activite"));
                 /*
                   Panier p = new Panier();
                int j = rs.getInt("idpanier");
                p.setIdpanier(j);
                C.setPanier(p);   */
                
                Sponsors p = new Sponsors();
                int j = rs.getInt("ID_Sponsor");
                p.setID_Sponsor(j);
                Bd.setSponsors(p);
                
                
                
                myList.add(Bd);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
      /*  public void modifierbudget(budget b2) throws SQLException, NoSuchAlgorithmException {
        
            String requete4 = "UPDATE budget SET "
                    + "  Montant='"+b2.getMontant()"'"
                    + ", Activite='"+b2.getActivite()+"'"
              + ", ID_Sponsor='"+b2.getSponsors()+"' where ID_Budget  = "+b2.getID_Budget()+"";  
                                   
                    Statement stm = cnx2.createStatement();
                    stm.executeUpdate(requete4);
                    
                    
                    
       
}
        
        */
          public void modifierbudget(budget e) throws SQLException, NoSuchAlgorithmException {
      
              String req = "UPDATE budget SET "
                + " Montant='"+e.getMontant()+"'"
                + ", Activite='"+e.getActivite()+"'"
                + ", ID_Sponsor='"+e.getSponsors()+"' where ID_Budget  = "+e.getID_Budget()+"";
        PreparedStatement pst = cnx2.prepareStatement(req);
        pst.executeUpdate(req);
    } 
        
        
        
    
    public void SupprimerUser(budget b) throws SQLException {

        String req = "DELETE FROM budget WHERE ID_Budget =?";
        try {
            PreparedStatement ps = cnx2.prepareStatement(req);
            ps.setInt(1, b.getID_Budget());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
}
