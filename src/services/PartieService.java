/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import GUI.Equipe;
import entities.Partie;
import entities.Tournois;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Datasource;

/**
 *
 * @author ASUS
 */
public class PartieService {

    private Connection conn;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private Statement ste;

    public PartieService() {
        conn = Datasource.getInstance().getCnx();
    }

    public void ajouterPartie(Partie p) {
        String req = "INSERT INTO `partie` (`duree`, `score1`,`score2`, `date_derou`,`id_tournoi`,`id_equipe1`,`id_equipe2`) VALUES ('" + p.getDuree() + " ','"
                + "" + p.getScore1()+ "','" + p.getScore2() + "','" + p.getDate_deroul() + "','" + p.getId_tournoi() + "','" + p.getId_equipe1() + "','" + p.getId_equipe2() + "')";

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Partie ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierPartie(Partie m,int id){
        String req= "UPDATE partie SET duree= "+m.getDuree()+", score1="+m.getScore1()+", score2="+m.getScore2()+",date_derou='"+m.getDate_deroul()+"' WHERE idPartie="+id;
        
     try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Partie modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void suppPartie (int idPartie){
     String req = "DELETE FROM Partie WHERE idPartie = "+idPartie+";";

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Partie Supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
//    public List<Partie> affichPartie(){
//     List<Partie> par = new ArrayList<Partie>();
//      
//      Tournois tour = new Tournois();
//      Equipe eq1 = new Equipe();
//      Equipe eq2 = new Equipe();
//      
//        String req = "SELECT * from `partie`";
//        
//        try {
//            pst = conn.prepareStatement(req);
//            ResultSet rs= pst.executeQuery();
//            
//            while(rs.next()){
//                Equipe id_equipe = new Equipe ();
//                Tournois id_tournoi = new Tournois();
//                Partie p = new Partie();
//                p.setIdPartie( rs.getInt("idPartie") );
//                p.setDate_deroul(rs.getDate("date_derou"));
//                p.setDuree(rs.getFloat("duree"));
//                p.setScore1(rs.getString("score1"));
//                p.setScore2(rs.getString("score2"));
//                
//                int id_tournois=rs.getInt("id_tournoi");
//                int ideq1=rs.getInt("id_equipe1");
//                int ideq2=rs.getInt("id_equipe2");
//                String req1 = "SELECT * from `tournois` where id="+id_tournois+"";
//                String req2 = "SELECT * from `equipe` where id_equipe="+ideq1+"";
//                String req3 = "SELECT * from `equipe` where id_equipe="+ideq2+"";
//        try {
//            pst1 = conn.prepareStatement(req1);
//            ResultSet rs1= pst1.executeQuery();
//            
//            while(rs1.next()){
//                
//                
//                tour.setId(rs1.getInt("id") );
//                tour.setDate_deb(rs1.getDate("date_deb"));
//                tour.setDate_fin(rs1.getDate("date_fin"));
//                tour.setNb_equipes(rs1.getInt("nb_equipes"));
//                tour.setJeux(rs1.getString("jeux"));
//                tour.setNom(rs1.getString("nom"));
//                
//                
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            pst1 = conn.prepareStatement(req2);
//            ResultSet rs1= pst1.executeQuery();
//            
//            while(rs1.next()){
//                
//                eq1.setId(rs1.getInt("id_equipe"));
//                eq1.setNom(rs1.getString("nom"));
//                eq1.setNbrJoueur(rs1.getString("nbrJoueur"));
////            
//                
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } try {
//            pst1 = conn.prepareStatement(req3);
//            ResultSet rs1= pst1.executeQuery();
//            
//            while(rs1.next()){
//                
//                eq2.setId(rs1.getInt("id_equipe"));
//                eq2.setNom(rs1.getString("nom"));
//                eq2.setNbrJoueur(rs1.getString("nbrJoueur"));
////            
//                
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//                p.setId_tournoi(tour);
//                p.setId_equipe1(eq1);
//                p.setId_equipe2(eq2);
//                par.add(p);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//      return par;
//    }
    public ObservableList<Partie> afficherobserv() {
       ObservableList<Partie> ltr = FXCollections.observableArrayList();
       // List <Tournois> id = new ArrayList<>(); 
        String req = "SELECT * from `partie`";

        try {
            pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
              Partie p = new Partie();
                p.setIdPartie( rs.getInt("idPartie") );
                p.setDate_deroul(rs.getDate("date_derou"));
                p.setDuree(rs.getFloat("duree"));
                p.setScore1(rs.getInt("score1"));
                p.setScore2(rs.getInt("score2"));
                p.setId_equipe1(rs.getInt("id_equipe1"));
                p.setId_equipe2(rs.getInt("id_equipe2"));
                 p.setId_tournoi(rs.getInt("id_tournoi"));
               ltr.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ltr;
        
    }
}
