/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.*;
/**
 *
 * @author 21654
 */
public class Datasource {
    private String url = "jdbc:mysql://localhost:3306/haven";
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
