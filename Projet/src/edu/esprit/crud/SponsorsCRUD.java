/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.entities.Sponsors;
import edu.esprit.utils.MyConnexion;
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
            pst.setString(1, P.getNom());
            pst.setString(2, P.getPrenom());
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
                Sponsors Sp = new Sponsors();
                Sp.setID_Sponsor(rs.getInt(1));
                Sp.setNom(rs.getString("Nom_Sponsor"));
                Sp.setPrenom(rs.getString("Prenom_Sponsor"));
                Sp.setMontant(rs.getInt(4));
                Sp.setDuree_spons(rs.getInt(5));
                myList.add(Sp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    public void modifierUser(Sponsors s1,Sponsors s2) {
        try {
            String requete4 = "UPDATE sponsors SET Nom_Sponsor='"+s2.getNom()+"', Prenom_Sponsor='"+s2.getPrenom()+"', Montant='"+s2.getMontant()+"', Duree_spons='"+s2.getDuree_spons()+"' WHERE ID_Sponsor  ="+s1.getID_Sponsor();
                    Statement stm = cnx2.createStatement();
                    stm.executeUpdate(requete4);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
    
    public void SupprimerUser(Sponsors u) throws SQLException {

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

