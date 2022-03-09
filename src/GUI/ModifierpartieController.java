/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Partie;
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
public class ModifierpartieController implements Initializable {
public static Partie partie;
    @FXML
    private TextField tfidtour;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfidtour.setVisible(false);
        tfideq1.setVisible(false);
        tfideq2.setVisible(false);
    }    

    @FXML
    private void ajouterpartie(ActionEvent event) {
        
        Notifications notificationBuilder = Notifications.create()
                .title("Match modifiée")
                .text("Match modifiée");
        notificationBuilder.showConfirm();
        float duree = Float.parseFloat(tfDuree.getText());
        int score1 = Integer.parseInt(tfsc1.getText());
        int score2 = Integer.parseInt(tfsc2.getText());
        Date date_deroul = Date.valueOf(tfDateDer.getValue());
        int idPartie = partie.getIdPartie();
        Partie t = new Partie(duree, score1,score2, date_deroul);
        PartieService ts = new PartieService();
        ts.modifierPartie(t,idPartie);
    }
    
}
