/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;
import tn.esprit.entities.user;
import tn.esprit.utils.Datasource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;
import tn.esprit.entities.reclamation;
/**
 *
 * @author waela
 */
public class userService {
    public void ajouterUser(user u) {

        try {
            String requete = "INSERT INTO user(id) values( ?)";
            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            
            pst.setString(2, u.getNom());
           
            pst.executeUpdate();
            System.out.println("user ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public List<reclamation> listerUser() {
        List<reclamation> listR = new ArrayList<>();

        try {

            String requete = "SELECT * FROM User";
            Statement st = Datasource.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                user u1 = new user();
               
               
                u1.setNom(rs.getString("nom"));
                reclamation r1 = null;
               

                listR.add(r1);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listR;

    }
    public void modifierUser(int id, user r) {

        

            try {
                String requete = "update user set content = ?  where id = ?";
                PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
                pst.setInt(1, r.getId());
                pst.setString(2, r.getNom());
                pst.setInt(3, id);
                pst.executeUpdate();

                System.out.println("user modifiée !");

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        
    }
    public void supprimerUser(int id) {

        try {
            String requete = "DELETE FROM user where id = ?";

            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("user supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
