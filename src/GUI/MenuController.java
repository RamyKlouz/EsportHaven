/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ZoomEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MenuController implements Initializable {

    @FXML
    private Button btntourn;
    @FXML
    private ImageView imgView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Image im=new Image("File:/C:\\Users\\ramyc\\Desktop\\logo.png") ;
       imgView.setImage(im);
    }

    @FXML
    private void gestiontournois(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/affichertournois.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gestionpartie(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/afficherpartie.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gestionequipe(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/sample.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gestionjoueur(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/JoueurInterface.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sponsoriser(ActionEvent event) {

        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/edu/esprit/gui/AfficherSponsors.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gererboutique(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/AjouterProd.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  /*

    @FXML
    private void gestiontournois(ZoomEvent event) {
        
    }*/

    @FXML
    private void adduser(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/resources/AjouterCompteFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gereruser(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Resources/ListeUtilisateurs.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            new animatefx.animation.ZoomIn(parent).play();

        } catch (IOException ex) {
            Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*@FXML
    private void gestiontournois(ZoomEvent event) {
    }*/



    @FXML
    private void logout(ActionEvent event) {
                                        Stage stage1 = (Stage) btntourn.getScene().getWindow();
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
