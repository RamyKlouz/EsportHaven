/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;
import java.sql.*;
/**
 *
 * @author sk4nd
 */
public class MyConnexion {
    
    public String url="jdbc:mysql://localhost:3306/haven";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConnexion instance;

    private MyConnexion() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
        public static MyConnexion getInstance() {
        if(instance == null){
            instance = new MyConnexion();
        }
        return instance;
    }
    public Connection getCnx(){
        return cnx;
    }
    
    
}
