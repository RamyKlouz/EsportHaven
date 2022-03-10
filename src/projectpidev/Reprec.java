/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpidev;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import tn.esprit.entities.reclamation;
import tn.esprit.services.ReponseService;

/**
 *
 * @author waela
 */
public class Reprec extends Application {


  
    @FXML
    private Button envoyerMessageButtonn;
    @FXML

    private TextField sujetTextField;
    @FXML
    private TextArea messageTextField;
      @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(email.getText());
        AddRep(content.getText());
       
       
        Notifications NotificationBuilder;
        NotificationBuilder = Notifications.create()
                .title("reclamation ")
                .text("envoyer")
           
                .position(Pos.TOP_LEFT);
        NotificationBuilder.show();
    }
      private void AddRep(String content) { 
        ReponseService rs = new ReponseService();
        reclamation r;
        r = new reclamation();
        r.setDescription(content);
        rs.ajouterRep2(r);
        System.out.println("Reponce ajouter ");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
