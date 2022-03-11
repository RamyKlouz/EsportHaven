package views;

import GUI.AffichertournoisController;
import entities.utilisateur;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.UtilisateurService;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.Button;

import javax.mail.MessagingException;


public class ListeUtilisateursFXMLControler implements Initializable {

    public TextField nouvrole;
    public TableColumn<utilisateur , Integer> idus;
    public TableColumn<utilisateur , String> loginus;
    public TableColumn<utilisateur , String> nomus;
    public TableColumn<utilisateur , String> prenomus;
    public TableColumn<utilisateur , String> emailus;
    public TableColumn<utilisateur , Integer> numtelus;
    public TableColumn<utilisateur , String> pays;
    public TableColumn<utilisateur,String> roleus;
    public TableColumn<utilisateur,Boolean> etatus;
    public TableColumn<utilisateur,Boolean> banneus;
    public TableView<utilisateur> tabuser;
    public ObservableList<utilisateur> list;
    @FXML
    private Button banner;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void ajadmin(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent parent;
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/resources/AjouterCompteFXML.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Ajouter Compte");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void modifadmin(ActionEvent actionEvent) {
        UtilisateurService sp = new UtilisateurService();
        utilisateur p = new utilisateur();
        int id = p.setId(tabuser.getSelectionModel().getSelectedItem().getId());
        String role = nouvrole.getText();
        sp.modifier(role,id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("modifier avec succes");
        alert.show();
        nouvrole.setText("");

    }

    @FXML
    public void supadmin(ActionEvent actionEvent) {
        UtilisateurService sp = new UtilisateurService();
        utilisateur p = new utilisateur();
        int id = p.setId(tabuser.getSelectionModel().getSelectedItem().getId());
        sp.supprimer(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Suppression avec succes");

    }

    @FXML
    public void banadmin(ActionEvent actionEvent) {
        UtilisateurService sp = new UtilisateurService();
        utilisateur p = new utilisateur();
        int id = p.setId(tabuser.getSelectionModel().getSelectedItem().getId());
        sp.banned(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("banner avec succes");
        alert.show();
    }

    @FXML
    public void debanadmin(ActionEvent actionEvent) {
        UtilisateurService sp = new UtilisateurService();
        utilisateur p = new utilisateur();
        int id = p.setId(tabuser.getSelectionModel().getSelectedItem().getId());
        sp.debanner(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("debanner avec succes");
        alert.show();
    }

    @FXML
    public void deconnectus(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent parent;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deconnection");
        alert.setContentText("etre vous sur de deconnecter ?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.close();
            try {
                parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/resources/HomeUsFXML.fxml")));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tableuser(SortEvent<TableView> tableViewSortEvent) {
        UtilisateurService ps = new UtilisateurService();
        ArrayList<utilisateur> u = new ArrayList<>();
        u = (ArrayList<utilisateur>) ps.afficher();
        ObservableList<utilisateur> obs = FXCollections.observableArrayList(u);
        tabuser.setItems(obs);
        idus.setCellValueFactory(new PropertyValueFactory<>("id"));
        loginus.setCellValueFactory(new PropertyValueFactory<>("login"));
        nomus.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomus.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailus.setCellValueFactory(new PropertyValueFactory<>("email"));
        numtelus.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        roleus.setCellValueFactory(new PropertyValueFactory<>("role"));
        etatus.setCellValueFactory(new PropertyValueFactory<>("etat"));
        banneus.setCellValueFactory(new PropertyValueFactory<>("banne"));

        try {
            list = FXCollections.observableArrayList(
                    ps.afficher()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* @FXML
    private void tableuser(SortEvent<C> event) {
    }*/

    @FXML
    private void back(ActionEvent event) {
        Stage stage1 = (Stage) banner.getScene().getWindow();
                      stage1.close();  
                      try {
           
                Parent page1 = FXMLLoader.load(getClass().getResource("/GUI/menu.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                 new animatefx.animation.ZoomIn(page1).play();

            } catch (IOException ex) {
                Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }

 /*  @FXML
    private void tableuser(SortEvent<C> event) {
    }*/

    /*@FXML
    private void tableuser(SortEvent<C> event) {
    }*/
}