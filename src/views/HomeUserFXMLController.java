package views;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UtilisateurService;
import utils.Datasource;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class HomeUserFXMLController implements Initializable {

    public CheckBox rememberme;
    @FXML
    private TextField loginuser ;
    @FXML
    private TextField motdepasseuser ;

    Preferences preferences ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        preferences = Preferences.userNodeForPackage(HomeUserFXMLController.class);
        if (preferences != null)
        {
            if(preferences.get("login",null) != null && !preferences.get("login",null).isEmpty())
            {
                loginuser.setText(preferences.get("login" , null));
                motdepasseuser.setText(preferences.get("mdp",null));
            }
        }

    }

    @FXML
    private void Authentifier(ActionEvent event) {

            Parent parent;
            Stage stage;
            String resultat;
            UtilisateurService sp = new UtilisateurService();
            utilisateur p = new utilisateur(loginuser.getText(), motdepasseuser.getText());

            resultat = sp.authentifier(p);

            String pwd = motdepasseuser.getText();
            String pwd1 = sp.crypt(pwd);
            String pw = p.getMdp();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Verifier");

            if (resultat.equals("Votre compte est desactiver ")) {
                alert.setContentText("Votre compte est desactiver ");
                alert.show();
            }
            else if ((loginuser.getText().isEmpty())&&(motdepasseuser.getText().isEmpty()))
            {
                alert.setContentText("Les champs sont vide ");
                alert.show();
            }
            else if (loginuser.getText().isEmpty())
            {
                alert.setContentText("Entrer un login ");
                alert.show();
            }
            else if (motdepasseuser.getText().isEmpty())
            {
                alert.setContentText("enter mot de passe ");
                alert.show();
            }
            else if (resultat.equals("Votre compte est banner "))
            {
                alert.setContentText("Votre compte est benner ");
                alert.show();
            }
            else if ((resultat.equals("Connexion réussie !" ))||(pwd1.equals(pw)))
            {
                if (rememberme.isSelected())
                {
                    preferences.put("login",loginuser.getText());
                    preferences.put("mdp",motdepasseuser.getText());
                } else {
                    preferences.put("login","");
                    preferences.put("mdp","");
                }

                alert.setContentText("Connexion réussie !");

                alert.showAndWait();

                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                stage.close();
                try {
                    //parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/resources/ListeUtilisateurs.fxml")));
                    parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/GUI/menu.fxml")));
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.setTitle("Admin");
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }


            } else
            {
                alert.setContentText("Login ou Mot de passe incorrect !");
                alert.show();
            }
            loginuser.setText("");
            motdepasseuser.setText("");


        }



    @FXML
    public void Creernouveau(MouseEvent mouseEvent) {
        Stage stage;
        Parent parent;
        stage = (Stage) ((Label) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(CreateAccountFXML.class.getResource("/resources/CreateAcFXML.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Creer un nouveau compte ");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param mouseEvent
     */
    public void motdepasseoublie(MouseEvent mouseEvent) {
        Stage stage;
        Parent parent;
        stage = (Stage) ((Label) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(CreateAccountFXML.class.getResource("/resources/MotdepasseFXML.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Creer un nouveau compte ");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
