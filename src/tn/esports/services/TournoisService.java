/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.services;

import java.util.List;
import tn.esports.entities.IService;
import tn.esports.entities.Tournois;
import tn.esports.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TournoisService implements IService<Tournois> {

    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public TournoisService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(Tournois t) {
        String req = "INSERT INTO `tournois` (`nom`, `nb_equipes`, `date_deb`,`date_fin`, `jeux` ) VALUES ('" + t.getNom() + " ','"
                + "" + t.getNb_equipes() + "','" + t.getDate_deb() + "','" + t.getDate_fin() + "','" + t.getJeux() + "')";

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Tournoi ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//        public void ajouterPst(Tournois t){
//        String req = "INSERT INTO `tournois` (`nom`, `nb_equipes`, `date_deb`,`date_fin`, `partie`, `jeux` ) VALUES (?,?)";
//        
//        try {
//            pst = conn.prepareStatement(req);
//            pst.setString(1, t.getNom());
//            pst.setInt(2, t.getNb_equipes());
//            pst.setDate(3,t.getDate_deb());
//            pst.setDate(4,t.getDate_fin());
//           // pst.set(5, t.getPartie() );
//            pst.setString(6, t.getJeux());
//            pst.executeUpdate();
//            System.out.println("tournoi ajoutée");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    
    
    @Override
    public void supprimer(int idTournois) {
        String req = "DELETE FROM Tournois WHERE id = "+idTournois+";";

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Tournoi Supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Tournois m) {
   String req = "UPDATE Tournois SET nom='"+m.getNom()+"', date_deb='"+ m.getDate_deb()+"', date_fin='"+m.getDate_fin()+"', nb_equipes='"+m.getNb_equipes()+"', jeux= '"+m.getJeux()+"' WHERE id="+m.getId()+";";  
         

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Tournoi Modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Tournois> afficher() {
       List<Tournois> ltr = new ArrayList<Tournois>();

        String req = "SELECT * from `Tournois`";

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Tournois t = new Tournois();
                t.setId(rs.getInt("id"));
                t.setNom(rs.getString("nom"));
                t.setDate_deb(rs.getDate("date_deb"));
                t.setDate_fin(rs.getDate("date_fin"));
                t.setNb_equipes(rs.getInt("nb_equipes"));
                t.setJeux(rs.getString("jeux"));
                ltr.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ltr;
        
    }
       
}
