/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.TournoisService;
import entities.Tournois;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterTournoisController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNbEq;
    @FXML
    private TextField tfJeu;
    @FXML
    private Button tfEnregistrer;
    @FXML
    private DatePicker tfDateFin;
    @FXML
    private DatePicker tfDateDeb;
    private TextField tfid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveTournois(ActionEvent event) {
        Notifications notificationBuilder = Notifications.create()
                .title("Tournoi ajoutée")
                .text("Tournoi ajoutée");
        notificationBuilder.showConfirm();
               
               
                
        String nom = tfNom.getText();
        Date date_deb = Date.valueOf(tfDateDeb.getValue());
        Date date_fin = Date.valueOf(tfDateFin.getValue());
        String jeux = tfJeu.getText();
        int nb_equipes = Integer.parseInt(tfNbEq.getText());
        
        Tournois t = new Tournois(nom, date_deb, date_fin, nb_equipes, jeux);
        TournoisService ts = new TournoisService();
        ts.ajouter(t);
        Stage stage = (Stage) tfid.getScene().getWindow();
                stage.close();
    }

    
    
}
