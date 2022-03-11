package projectpidev;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI.AffichertournoisController;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.controlsfx.control.Notifications;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    private AnchorPane rootPane;
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @FXML
    private Label emailValidation;
    
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
        r.setEmail(email);
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
    
    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("RepondeReclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void validate(KeyEvent event) {
        
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email.getText());
        if(email.getText().equals("")){
            emailValidation.setText("Please enter an email");
        } else 
        if (matcher.find()) {      
            emailValidation.setVisible(false);
        } else {
            emailValidation.setText("Please enter a correct email");
            emailValidation.setVisible(true);
        }
    }

    @FXML
    private void back(ActionEvent event) {
        Stage stage1 = (Stage) button.getScene().getWindow();
                      stage1.close();  
                      try {
           
                Parent page1 = FXMLLoader.load(getClass().getResource("/GUI/ClientSide.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                 new animatefx.animation.ZoomIn(page1).play();

            } catch (IOException ex) {
                Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }

    @FXML
    private void logout(ActionEvent event) {
                Stage stage1 = (Stage) button.getScene().getWindow();
                      stage1.close();  
                      try {
           
                Parent page1 = FXMLLoader.load(getClass().getResource("/resources/HomeUsFXML.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                 new animatefx.animation.ZoomIn(page1).play();

            } catch (IOException ex) {
                Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    
}
