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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button btnspon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void gestionsponbudget(ActionEvent event) {
        Stage stage1 = (Stage) btnspon.getScene().getWindow();
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
            Logger.getLogger(ex.getMessage());
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

    @FXML
    private void fairecmd(ActionEvent event) {
        Stage stage1 = (Stage) btntourn.getScene().getWindow();
        stage1.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tn/esprit/gui/CommandeProd.fxml"));
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

}
