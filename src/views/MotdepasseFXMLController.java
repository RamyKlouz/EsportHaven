/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author 21654
 */
public class MotdepasseFXMLController implements Initializable {

    @FXML
    private TextField emailforget;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void validforget(ActionEvent event) throws MessagingException {
        UtilisateurService ps = new UtilisateurService();
        String email = emailforget.getText();
        ps.oubliemdp(email);
    }
    
}
