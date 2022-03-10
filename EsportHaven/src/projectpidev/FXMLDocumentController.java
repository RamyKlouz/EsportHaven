    package projectpidev;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.management.Notification;
import tn.esprit.entities.reclamation;
import tn.esprit.services.ReclamationService;

/**
 *
 * @author waela
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML

    private TextField email;
    @FXML
    private TextArea content;



    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(email.getText());
        AddRec(content.getText(), email.getText());
       
       
        Notifications NotificationBuilder = Notifications.create()
                .title("reclamation ")
                .text("envoyer")
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_LEFT);
        NotificationBuilder.show();

    }

    private void AddRec(String content, String email) { 
        ReclamationService rs = new ReclamationService();
        reclamation r;
        r = new reclamation();
        r.setDescription(content);
        rs.ajouterReclamation2(r);
        System.out.println("Reclamation ajouter ");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Object title(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object text(String reclamation_envoyer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object hideAfter(Duration seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void position(Pos pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void creat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

