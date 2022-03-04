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
import tn.esports.services.PartieService;
import tn.esports.entities.Partie;
import tn.esports.entities.Equipe;
import tn.esports.entities.Tournois;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouModifPartieController implements Initializable {

    @FXML
    private TextField tfsc1;
    @FXML
    private TextField tfDuree;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfideq1;
    @FXML
    private TextField tfideq2;
    @FXML
    private TextField tfsc2;
    @FXML
    private DatePicker tfDateDer;
    @FXML
    private Button tfajoupar;
    @FXML
    private Button tfmodifpar;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterpartie(ActionEvent event) {
        
        Notifications notificationBuilder = Notifications.create()
                .title("Match ajoutée")
                .text("Match ajoutée");
        notificationBuilder.showConfirm();
        Tournois id_tournoi = new Tournois();
        float duree = Float.parseFloat(tfDuree.getText());
        String score1 = tfsc1.getText();
        String score2 = tfsc2.getText();
        Date date_deroul = Date.valueOf(tfDateDer.getValue());
        id_tournoi.setId(Integer.parseInt(tfId.getText()));
        Equipe id_equipe1 = new Equipe();
        id_equipe1.setId(Integer.parseInt(tfideq1.getText()));
        Equipe id_equipe2 = new Equipe();
        id_equipe2.setId(Integer.parseInt(tfideq2.getText()));
        Partie t = new  Partie(duree,score1,score2,date_deroul,id_tournoi,id_equipe1,id_equipe2) ;
        PartieService ts = new PartieService();
        ts.ajouterPartie(t);


    }

    @FXML
    private void modiferpartie(ActionEvent event) {
    }

 
    
}
