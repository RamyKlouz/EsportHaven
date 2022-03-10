package views;

import entities.utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.UtilisateurService;
import utils.Datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

public class AjouterCompteFXMLController {
    public TextField loginajout;
    public TextField nomajout;
    public TextField prenomajout;
    public TextField emailajout;
    public TextField numtelajout;
    public TextField paysajout;
    public TextField roleajout;
    public PasswordField motdepasseajout;

    public void validerajout(ActionEvent actionEvent) {

        Boolean etat = false ;
        Boolean banne = false;
        int id = 0 ;
        UtilisateurService sp = new UtilisateurService();
        utilisateur p = new utilisateur(id,loginajout.getText(), motdepasseajout.getText(),nomajout.getText(),prenomajout.getText(),emailajout.getText(),Integer.parseInt(numtelajout.getText()),paysajout.getText(),roleajout.getText(),etat,banne);
        String msg  = sp.ajouterPst(p);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if ((loginajout.getText().isEmpty()) || (motdepasseajout.getText().isEmpty()) || (nomajout.getText().isEmpty()) || (prenomajout.getText().isEmpty()) || (emailajout.getText().isEmpty()))
        {
            alert.setContentText("Remplir les champs obligatoirs");
            alert.show();
        }

        else if(msg.equals("cette login existe"))
        {
            alert.setContentText("cette login existe");
            alert.show();
        } else if (msg.equals("cette email existe deja"))
        {
            alert.setContentText("cette email existe deja");
            alert.show();
        } else {
            alert.setContentText("Le compte est cree ");
            alert.show();
            alert.setTitle("Success");
            loginajout.setText("");
            motdepasseajout.setText("");
            nomajout.setText("");
            prenomajout.setText("");
            emailajout.setText("");
            numtelajout.setText("");
            paysajout.setText("");
            roleajout.setText("");
        }
    }

    public void retourajout(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent parent;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("retour au menu principale");
        alert.setContentText("etre vous sur de quitter cette page ?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.close();
            try {
                parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/ListeUtilisateurs.fxml")));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Admin");
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
