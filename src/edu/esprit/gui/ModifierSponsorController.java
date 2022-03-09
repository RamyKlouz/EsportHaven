/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.crud.SponsorsCRUD;
import edu.esprit.entities.Sponsors;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sk4nd
 */
public class ModifierSponsorController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField Nom;
    @FXML
    private Button A;
    @FXML
    private TextField Duree_spons;
    @FXML
    private TextField Montant;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField prenom;
    @FXML
    private Label labelid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
           Nom.setText(AfficherSponsorsController.connectedSponsor.getNom_Sponsor());
         

        labelid.setText(Integer.toString(AfficherSponsorsController.connectedSponsor.getID_Sponsor()));
        
         prenom.setText(AfficherSponsorsController.connectedSponsor.getPrenom_Sponsor());
        Montant.setText(Integer.toString((int) AfficherSponsorsController.connectedSponsor.getMontant()));
             Duree_spons.setText(Integer.toString((int) AfficherSponsorsController.connectedSponsor.getDuree_spons()));

       
        
        
     
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
           SponsorsCRUD productService = new SponsorsCRUD();
         
            
                 
          Sponsors c = new Sponsors(Integer.parseInt(labelid.getText()),Nom.getText(),prenom.getText(), Integer.parseInt(Montant.getText()),  
                Integer.parseInt(Duree_spons.getText())
                );
            
                    
        
       
        productService.modifierSponsor(c);
        Parent page1 = FXMLLoader.load(getClass().getResource("AfficherSponsors.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Sponsors");
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
      Parent page1 = FXMLLoader.load(getClass().getResource("AfficherSponsors.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Sponsors");
        stage.setScene(scene);
        stage.show();  
        
    }
    
}
