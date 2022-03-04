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
import tn.esports.services.*;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DeleteAfficherPartieController implements Initializable {

    @FXML
    private Button tfbuttaff;
    @FXML
    private Button tfdel;
    @FXML
    private TextField tfid;
    @FXML
    private Label tfaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AffiPartie(ActionEvent event) {
       PartieService T = new PartieService();
        try
        {
            tfaff.setText(T.affichPartie().toString());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void deletePartie(ActionEvent event) {
        int id1 = Integer.parseInt(tfid.getText());
            PartieService T = new PartieService();
            T.suppPartie(id1);
    }
    
}
