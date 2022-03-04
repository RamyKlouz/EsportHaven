/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.gui;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;
import tn.esports.entities.Equipe;
import tn.esports.entities.Partie;
import tn.esports.services.PartieService;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifPartieController implements Initializable {

    
    @FXML
    private TextField tfidmatch;
    @FXML
    private TextField tfduree;
    @FXML
    private TextField tfsc1;
    
    @FXML
    private TextField tfsc2;
    @FXML
    private DatePicker tfdateder;
    @FXML
    private Button tfmodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifiermatch(ActionEvent event) {
                 Notifications notificationBuilder = Notifications.create()
                .title("Match modifiée")
                .text("Match modifiée");
        notificationBuilder.showConfirm();
        float duree = Float.parseFloat(tfduree.getText());
        String score1 = tfsc1.getText();
        String score2 = tfsc2.getText();
        Date date_deroul = Date.valueOf(tfdateder.getValue());
        int idPartie = Integer.parseInt((tfidmatch.getText()));
        Partie t = new Partie(duree, score1,score2, date_deroul);
        PartieService ts = new PartieService();
        ts.modifierPartie(t,idPartie);
    }
    
}
