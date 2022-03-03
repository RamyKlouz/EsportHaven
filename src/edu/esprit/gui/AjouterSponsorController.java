/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.crud.SponsorsCRUD;
import edu.esprit.entities.Sponsors;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * FXML Controller class
 *
 * @author fares
 */
public class AjouterSponsorController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextField Nom;
    @FXML
    private Button A;
    @FXML
    private TextField Duree_spons;
    @FXML
    private TextField Montant;
    @FXML
    private Hyperlink prec;
    @FXML
    private TextField prenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
     
        
        
        
        
        
        
    }    

 
    @FXML
    private void insert(ActionEvent event) throws IOException {
        SponsorsCRUD productService = new SponsorsCRUD();
         
        
           if (Nom.getText().equals("")
                || prenom.getText().equals("") 
                || Montant.getText().equals("")
                || Duree_spons.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
        
        
        
        Sponsors c = new Sponsors(Nom.getText(),prenom.getText(), Integer.parseInt(Montant.getText()),  
                Integer.parseInt(Duree_spons.getText())
                );
                    
        
        productService.ajouterSponsor2(c);
       
      Parent page1 = FXMLLoader.load(getClass().getResource("AfficherSponsors.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Sponsors");
        stage.setScene(scene);
        stage.show();
          
        
        try {
                                   sendMail("skander.jerbi@esprit.tn");
                               
                                   
                                
                                } catch (MessagingException ex) {
                                }  
        
        
           TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Ajouté un nouveau sponsor");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
          
        
        
        
    }

    @FXML
    private void prec(ActionEvent event) {
    }
    
    
        private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Vous Avez Ajouté un nouveau sponsor");
            message.setText("Vous Avez Ajouté un nouveau sponsor");
            return message;
        } catch (MessagingException ex) {
           
        }
        return null;
    }   
     public static void sendMail(String recipient) throws MessagingException {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "esportshaven10@gmail.com";
        String password = "Esportshaven5683@";
        Session session = Session.getInstance(properties, new Authenticator() {
             @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            
        Message message = prepareMessage(session, myAccountEmail, recipient);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }    
    
}
