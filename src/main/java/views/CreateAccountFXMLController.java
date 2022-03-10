package views;

import entities.utilisateur;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.UtilisateurService;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class CreateAccountFXMLController implements Initializable {

    @FXML
    private TextField ajlogin ;
    @FXML
    private TextField ajmdp ;
    @FXML
    private TextField ajnom ;
    @FXML
    private TextField ajprenom ;
    @FXML
    private TextField ajmail ;
    @FXML
    private TextField ajnumtel ;
    @FXML
    private TextField ajpays ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void validajout(ActionEvent event) {
        Boolean etat = false ;
        Boolean banne = false;
        String role = "user";
        int id = 0 ;
        UtilisateurService sp = new UtilisateurService();
        utilisateur p = new utilisateur(id,ajlogin.getText(), ajmdp.getText(),ajnom.getText(),ajprenom.getText(),ajmail.getText(),Integer.parseInt(ajnumtel.getText()),ajpays.getText(),role,etat,banne);
        String msg  = sp.cration_compte(p);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (msg.equals("cette login existe"))
        {
            alert.setContentText("cette login existe");
            alert.show();
        } else if (msg.equals("cette email existe deja"))
        {
            alert.setContentText("cette email existe deja");
            alert.show();
        }
        else if ((ajlogin.getText().isEmpty()) || (ajmdp.getText().isEmpty()) || (ajnom.getText().isEmpty()) || (ajprenom.getText().isEmpty()) || (ajmail.getText().isEmpty()))

        {
            alert.setContentText("Remplir les champs obligatoirs");
            alert.show();
        }
        else {
            alert.setContentText("Votre compte est cree ");
            alert.show();
            alert.setTitle("Success");
            ajlogin.setText("");
            ajmdp.setText("");
            ajnom.setText("");
            ajprenom.setText("");
            ajmail.setText("");
            ajnumtel.setText("");
            ajpays.setText("");
        }
    }
    @FXML
    private void retouraj(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent parent;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("retour a l'authentification");
        alert.setContentText("etre vous sur de quitter cette page ?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();
            try {
                parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/HomeUsFXML.fxml")));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

}