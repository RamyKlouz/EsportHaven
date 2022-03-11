/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import services.TournoisService;

/**
 * FXML Controller class
 *
 * @author Firas CHKOUNDALI
 */
public class ModifiertournoiController implements Initializable {
public static Tournois tournoi;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfNom.setText(tournoi.getNom());
        tfNbEq.setText(Integer.toString(tournoi.getNb_equipes()));
        tfJeu.setText(tournoi.getJeux());
        
        
    }    

    @FXML
    private void SaveTournois(ActionEvent event) {
          Notifications notificationBuilder = Notifications.create()
                .title("Tournoi modifiée")
                .text("Match modifiée");
        notificationBuilder.showConfirm();
         String nom = tfNom.getText();
        Date date_deb = Date.valueOf(tfDateDeb.getValue());
        Date date_fin = Date.valueOf(tfDateFin.getValue());
        String jeux = tfJeu.getText();
        int nb_equipes = Integer.parseInt(tfNbEq.getText());
     
        Tournois t = new Tournois( tournoi.getId(), nom,  date_deb, date_fin,  nb_equipes,  jeux);
        TournoisService ts = new TournoisService();
        ts. modifier(t);
    }
    
}
