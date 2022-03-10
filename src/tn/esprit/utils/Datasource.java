/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.utils;
import java.sql.*;

/**
 *
 * @author remo
 */
public class Datasource {
<<<<<<< HEAD
    private String url = "jdbc:mysql://localhost:3306/pidev";
=======
    private String url = "jdbc:mysql://localhost:8889/pidev";
>>>>>>> 2369386a953b614a7e7a1b661b6d06aa78c263ca
    private String user = "root";
    private String password = "";

    private Connection cnx;
    private static Datasource instance;
    
    private Datasource() {
        
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Datasource getInstance() {
        if(instance == null){
            instance = new Datasource();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }    
    
}
