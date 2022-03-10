/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import tn.esprit.entities.reclamation;
import tn.esprit.utils.Datasource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI GAMMING
 */
public class ReclamationService {


    public void ajouterReclamation2(reclamation r) {

        try {
            String requete = "INSERT INTO reclamation(content) values( ?)";
            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            
            pst.setString(2, r.getDescription());
           
            pst.executeUpdate();
            System.out.println("Reclamation ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<reclamation> listerReclamations() {
        List<reclamation> listR = new ArrayList<>();

        try {

            String requete = "SELECT * FROM reclamation";
            Statement st = Datasource.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                reclamation r1 = new reclamation();
               
               
                r1.setDescription(rs.getString("content"));
               

                listR.add(r1);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listR;

    }

    public void modifierReclamation(int id, reclamation r) {

        

            try {
                String requete = "update reclamation set content = ?  where id_rec = ?";
                PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
                pst.setInt(1, r.getId());
                pst.setString(2, r.getDescription());
                pst.setInt(3, id);
                pst.executeUpdate();

                System.out.println("Reclamation modifiée !");

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        
    }

    public void supprimerReclamation(int id) {

        try {
            String requete = "DELETE FROM reclamation where id_rec = ?";

            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

 

   

}
