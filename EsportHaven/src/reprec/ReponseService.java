/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprec;


import tn.esprit.utils.Datasource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.reponse;

/**
 *
 * @author MSI GAMMING
 */
public class ReponseService {


 public void ajouterRep2(reponse r) {

        try {
            String requete = "INSERT INTO reponse_reclam (content) values(?)";
            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            
            pst.setString(1, r.getDescription());
           
            pst.executeUpdate();
            System.out.println("Reponce  ajoutée !");
        } catch (SQLException ex) {
            System.err.println("Database error"+ex.getMessage());
        }

    }

    public List<reponse> listereponse() {
        List<reponse> listR = new ArrayList<>();

        try {

            String requete = "SELECT * FROM reponse_reclam re , reclamation r ,user u WHERE re.id_answer=r.id_rec and re.id_answer=u.id";
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
            String requete = "DELETE FROM reponse_reclam re , reclamation r user u WHERE re.id_answer=r.id_rec AND id_answer= ";

            PreparedStatement pst = Datasource.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

 

   

}
