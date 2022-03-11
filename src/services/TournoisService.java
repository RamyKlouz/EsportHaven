/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import entities.IService;
import entities.Tournois;
import utils.Datasource;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class TournoisService implements IService<Tournois> {

    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public TournoisService() {
        conn = Datasource.getInstance().getCnx();
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
    public void supprimer(int id) {
        String req1 = "DELETE FROM PARTIE WHERE id_tournoi ="+id;
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        String req = "DELETE FROM Tournois WHERE id = "+id;
        

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
 public ObservableList<Tournois> afficherobserv() {
       ObservableList<Tournois> ltr = FXCollections.observableArrayList();
       // List <Tournois> id = new ArrayList<>(); 
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
    
    public ObservableList<Tournois> afficherobserv(String nom) {
       ObservableList<Tournois> ltr = FXCollections.observableArrayList();
       // List <Tournois> id = new ArrayList<>(); 
        String req = "SELECT * from `Tournois` where nom like '%"+nom+"%'";

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
    
    @Override
    public Tournois retrieveTournoisByNom(String nom) {
        Tournois cat = new Tournois(); 
        String query = "SELECT * FROM Tournois WHERE nom like'" + nom + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
               cat.setNom(rs.getString("nom"));
               cat.setDate_deb(rs.getDate("date_deb"));
               cat.setDate_fin(rs.getDate("Date_fin"));
               cat.setJeux(rs.getString("jeux"));
               cat.setNb_equipes(rs.getInt("nb_equipes"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cat;
    }  
//    
//  public Tournois sortedByDate ()
//          { List<Tournois> ts = new ArrayList<Tournois>();
//Tournois.stream()
//                    .sorted((a, b) -> Double.compare(a.getDate_deb(), b.getDate_deb()))
//                    .forEach(x -> System.out.println(" Tournois trié " + x));}
    
    public Tournois toptour() {
       ObservableList<Tournois> ltr = FXCollections.observableArrayList();
       // List <Tournois> id = new ArrayList<>(); 
        String req = "SELECT * from `Tournois` order by nb_equipes desc";

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
        return ltr.get(0);
        
    }
    
}
