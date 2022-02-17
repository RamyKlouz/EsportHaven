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
import utils.Datasource;
import entities.utilisateur;

/**
 *
 * @author 21654
 */
public class UtilisateurService {
    private final Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public UtilisateurService() {
        conn = Datasource.getInstance().getCnx();
    }
    
    /**
     *
     * @param p
     */
    public void ajouter(utilisateur p){
        String req = "INSERT INTO `utilisateur` (`nom`, `prenom`) VALUES ('"+ p.getNom() +"','"+ p.getPrenom() +"')";
        
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("personne ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void ajouterPst(utilisateur p){
        String req = "INSERT INTO `utilisateur` (`id`,`login`,`mdp`,`nom`, `prenom`,`email`,`num_tel`,`pays`,`role`) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getLogin());
            pst.setString(3, p.getMdp());
            pst.setString(4, p.getNom());
            pst.setString(5, p.getPrenom());
            pst.setString(6, p.getEmail());
            pst.setInt(7, p.getNumtel());
            pst.setString(8, p.getPays());
            pst.setString(9, p.getRole());
            pst.executeUpdate();
            System.out.println("personne ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<utilisateur> afficher(){
        List<utilisateur> utilisateurs = new ArrayList<>();
        
        String req = "SELECT * from `utilisateur`";
        
        try {
            pst = conn.prepareStatement(req);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
                utilisateur p = new utilisateur();
                p.setId(rs.getInt(1));
                p.setLogin( rs.getString(2) );
                p.setMdp(rs.getString(3));
                p.setNom(rs.getString(4));
                p.setPrenom(rs.getString(5));
                p.setEmail(rs.getString(6));
                p.setNumtel(rs.getInt(7));
                p.setPays(rs.getString(8));
                p.setRole(rs.getString(9));
                utilisateurs.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return utilisateurs;
    }

    public void supprimer() {
        List<utilisateur> utilisateurs = new ArrayList<>();

        String query = "DELETE FROM `utilisateur` WHERE id = 5";

        try
        {


            pst = conn.prepareStatement(query);
            pst.executeUpdate();


        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return;
    }

    public void modifier() {
        String sql = "UPDATE utilisateur SET login = 'ramy2' WHERE id = 3";

        try {

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("personne modifier");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static class utilistaeur {

        public utilistaeur() {
        }
    }
    
}
