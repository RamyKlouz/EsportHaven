/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Partie;
import entities.Tournois;
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
import services.PartieService;

/**
 * FXML Controller class
 *
 * @author Firas CHKOUNDALI
 */
public class AjouterpartieController implements Initializable {

    @FXML
    private TextField tfsc1;
    @FXML
    private TextField tfDuree;
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
    private TextField tfidtour;

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
        float duree = Float.parseFloat(tfDuree.getText());
        int score1 = Integer.parseInt(tfsc1.getText());
        int score2 = Integer.parseInt(tfsc2.getText());
        Date date_deroul = Date.valueOf(tfDateDer.getValue());
        int id_equipe1=Integer.parseInt(tfideq1.getText());
        int id_equipe2=Integer.parseInt(tfideq2.getText());
        int idtour=Integer.parseInt(tfidtour.getText());
        Partie t = new  Partie(duree,score1,score2,date_deroul,idtour,id_equipe1,id_equipe2) ;
        PartieService ts = new PartieService();
        ts.ajouterPartie(t);
    }
    
}
