/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esports.entities.Partie;
import tn.esports.utils.DataSource;

/**
 *
 * @author ASUS
 */
public class PartieService {

    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public PartieService() {
        conn = DataSource.getInstance().getCnx();
    }

    public void ajouterPartie(Partie p) {
        String req = "INSERT INTO `partie` (`duree`, `score`, `date_derou`,`id_tournoi`) VALUES ('" + p.getDuree() + " ','"
                + "" + p.getScore() + "','" + p.getDate_deroul() + "','" + p.getIdTournois() + "')";

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Partie ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierPartie(Partie m){
        String req= "UPDATE partie SET duree= "+m.getDuree()+", score='"+m.getScore()+"',date_derou='"+m.getDate_deroul()+"' WHERE idPartie="+m.getIdPartie()+";";
        
     try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Partie ajoutée");
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
    
    public List<Partie> affichPartie(){
     List<Partie> par = new ArrayList<Partie>();
        
        String req = "SELECT * from `partie`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                Partie p = new Partie();
                p.setIdPartie( rs.getInt("idPartie") );
                p.setDate_deroul(rs.getDate("date_derou"));
                p.setDuree(rs.getFloat("duree"));
                p.setScore(rs.getString("score"));
                p.setIdTournois(rs.getInt("id_tournoi"));
                par.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return par;
    }
    
}
