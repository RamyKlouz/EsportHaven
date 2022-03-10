/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import tn.esprit.entities.reponse;
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
public class ReponseService {




    public List<reponse> listereponse() {
        List<reponse> listR = new ArrayList<>();

        try {

            String requete = "SELECT * FROM reponse_reclam re , reclamation r WHERE re.id_answer=r.id_rec";
            Statement st = Datasource.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                reponse r = new reponse();
               
               
                r.setContent(rs.getString("content"));
               

                listR.add(r);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listR;

    }

   

    public void supprimerReclamation(int id) {

        try {
            String requete = "DELETE FROM reponse_reclam re , reclamation r WHERE re.id_answer=r.id_rec AND id_answer= ?";

            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

 

   

}
