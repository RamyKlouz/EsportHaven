/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.entities.Sponsors;
import edu.esprit.utils.MyConnexion;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sk4nd
 */
public class SponsorsCRUD {
    
    Connection cnx2;
    
    public SponsorsCRUD(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    
    public void ajouterSponsor (){
        try {
            String requete = "INSERT INTO sponsors (Nom_Sponsor,Prenom_Sponsor,Montant,Duree_spons) VALUES ('Dupont','Julien',120,152)";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajoutee avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterSponsor2(Sponsors P){
        String requete2 = "INSERT INTO sponsors (Nom_Sponsor,Prenom_Sponsor,Montant,Duree_spons) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, P.getNom_Sponsor());
            pst.setString(2, P.getPrenom_Sponsor());
            pst.setInt(3, P.getMontant());
            pst.setInt(4, P.getDuree_spons());
            pst.executeUpdate();
            System.out.println("Votre sponsor est ajoute!");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
    
    
    
      
    public List<Sponsors> AfficherSponsor(){
        List<Sponsors> myList = new ArrayList<>();
        try {      
            String requete3="SELECT * from sponsors";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                
                 Sponsors Sp = new Sponsors(rs.getInt("ID_Sponsor")
                         , rs.getString("Nom_Sponsor")
                    , rs.getString("Prenom_Sponsor")
                    , rs.getInt("Montant")
                    , rs.getInt("Duree_spons"));
                
               
                myList.add(Sp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
         public List<Sponsors> AfficherSponsors() throws SQLException {

        List<Sponsors> evenements = new ArrayList<>();
        String req = "select * from sponsors ";
        Statement stm = cnx2.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Sponsors e = new Sponsors(rst.getInt("ID_Sponsor")
                    , rst.getString("Nom_Sponsor")
                    , rst.getString("Prenom_Sponsor")
                    , rst.getInt("Montant")
                    , rst.getInt("Duree_spons"));
            evenements.add(e);
        }
        return evenements;
    }
    
    
    
    
    public void modifierSponsor(Sponsors s2) {
        try {
            String requete4 = "UPDATE sponsors SET Nom_Sponsor='"+s2.getNom_Sponsor()+"', Prenom_Sponsor='"+s2.getPrenom_Sponsor()+"', Montant='"+s2.getMontant()+"', Duree_spons='"+s2.getDuree_spons()+"' WHERE ID_Sponsor  ="+s2.getID_Sponsor();
                    Statement stm = cnx2.createStatement();
                    stm.executeUpdate(requete4);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
    

    
    public void SupprimerSponsor(Sponsors u) throws SQLException {

        String req = "DELETE FROM sponsors WHERE ID_Sponsor =?";
        try {
            PreparedStatement ps = cnx2.prepareStatement(req);
            ps.setInt(1, u.getID_Sponsor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
}

