/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.crud.BudgetCRUD;
import edu.esprit.entities.Sponsors;
import edu.esprit.entities.budget;
import edu.esprit.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class AjouterBudgetController implements Initializable {
 public AjouterBudgetController() throws IOException, SQLException, NoSuchAlgorithmException {

        connexion = MyConnexion.getInstance().getCnx();
    }
    Connection connexion;
    @FXML
    private Label welcome;
    @FXML
    private TextField Montant;
    @FXML
    private Button A;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField Activite;
    @FXML
    private ComboBox<Integer> Sponsorss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          BudgetCRUD pss = new BudgetCRUD();
        
        try {
            String req = "select * from sponsors";
            Statement stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery(req);
            
            while (rst.next()) {
                Sponsors a = new Sponsors(rst.getInt("ID_Sponsor"));
                
                Integer xx = rst.getInt("ID_Sponsor");
                
                Sponsorss.getItems().add(xx);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
       
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
       BudgetCRUD productService = new BudgetCRUD();
         Sponsors sp = new Sponsors (Sponsorss.getValue());
         
          
         
        
        
        budget c1 = new budget (Integer.parseInt(Montant.getText()),Activite.getText(),sp);
            productService.ajouterBudget2(c1);
       
      Parent page1 = FXMLLoader.load(getClass().getResource("AfficherBudget.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des budgets");
        stage.setScene(scene);
        stage.show();
        
                
           TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Ajouté un nouveau budget");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));  
        
        
        
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
     Parent page1 = FXMLLoader.load(getClass().getResource("AfficherBudget.fxml"));
        Scene scene = new Scene(page1, 1236, 785);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des budgets");
        stage.setScene(scene);
        stage.show();    
        
        
    }
    
}
