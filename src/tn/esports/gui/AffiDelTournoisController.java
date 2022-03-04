/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esports.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.esports.services.TournoisService;
import tn.esports.entities.Tournois;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffiDelTournoisController implements Initializable {

    @FXML
    private Label affichetournois;
    @FXML
    private TextField idsupprimer;
    @FXML
    private Button tfsupp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimertournois(ActionEvent event) {
        int id1 = Integer.parseInt(idsupprimer.getText());
            TournoisService T = new TournoisService();
            T.supprimer(id1);
    }

    @FXML
    private void affichetournois(ActionEvent event) {
        TournoisService T = new TournoisService();
        try
        {
            affichetournois.setText(T.afficher().toString());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
