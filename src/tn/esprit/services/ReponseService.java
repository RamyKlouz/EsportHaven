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
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.reclamation;
=======
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca

/**
 *
 * @author MSI GAMMING
 */
public class ReponseService {




    public List<reponse> listereponse() {
        List<reponse> listR = new ArrayList<>();

        try {

<<<<<<< HEAD
            String requete = "SELECT * FROM reponse_reclam re , reclamation r ,user u WHERE re.id_answer=r.id_rec and re.id_answer=u.id";
=======
            String requete = "SELECT * FROM reponse_reclam re , reclamation r WHERE re.id_answer=r.id_rec";
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
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
<<<<<<< HEAD
            String requete = "DELETE FROM reponse_reclam re , reclamation r user u WHERE re.id_answer=r.id_rec AND id_answer= ";
=======
            String requete = "DELETE FROM reponse_reclam re , reclamation r WHERE re.id_answer=r.id_rec AND id_answer= ?";
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca

            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

<<<<<<< HEAD
    public void ajouterRep2(reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

=======
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
 

   

}
