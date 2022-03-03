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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class AfficherSponsorsController implements Initializable {

    @FXML
    private TextField inputRech;
    @FXML
    private Button supp;
    @FXML
    private Button supp1;
    @FXML
    private Button Ajouter;
    @FXML
    private TableView<Sponsors> tableview;
    @FXML
    private TableColumn<Sponsors, Integer> ID_Sponsor;
    @FXML
    private TableColumn<Sponsors, String> Nom_Sponsor;
    @FXML
    private TableColumn<Sponsors, String> Prenom_Sponsor;
    @FXML
    private TableColumn<Sponsors, Integer> Montant;
    @FXML
    private TableColumn<Sponsors, Integer> Duree_spons;
 public ObservableList<Sponsors> list;
  public static Sponsors connectedSponsor;
  SponsorsCRUD cs = new SponsorsCRUD();
    @FXML
    private Hyperlink spon;
    @FXML
    private Hyperlink budg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          SponsorsCRUD pss = new SponsorsCRUD();
        ArrayList<Sponsors> c = new ArrayList<>();
        try {
            c = (ArrayList<Sponsors>) pss.AfficherSponsors();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherSponsorsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<Sponsors> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        ID_Sponsor.setCellValueFactory(new PropertyValueFactory<>("ID_Sponsor"));
        
 Nom_Sponsor.setCellValueFactory(new PropertyValueFactory<>("Nom_Sponsor"));
        Prenom_Sponsor.setCellValueFactory(new PropertyValueFactory<>("Prenom_Sponsor"));
        
        Montant.setCellValueFactory(new PropertyValueFactory<>("Montant"));
        Duree_spons.setCellValueFactory(new PropertyValueFactory<>("Duree_spons"));
             
            try {
            list = FXCollections.observableArrayList(
                    pss.AfficherSponsors()
            );     
        
         FilteredList<Sponsors> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Sponsors>) Sponsorss -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Sponsorss.getNom_Sponsor().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Sponsors> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // TODO
    }   
    
       public void resetTableData() throws SQLDataException, SQLException {

        List<Sponsors> listsponsors = new ArrayList<>();
        listsponsors = cs.AfficherSponsor();
        ObservableList<Sponsors> data = FXCollections.observableArrayList(listsponsors);
        tableview.setItems(data);
    }    
    

    @FXML
    private void supp(ActionEvent event) throws SQLException {
              if (event.getSource() == supp) {
            Sponsors e = new Sponsors();
            e.setID_Sponsor(tableview.getSelectionModel().getSelectedItem().getID_Sponsor());  
            SponsorsCRUD cs = new SponsorsCRUD();
            cs.SupprimerSponsor(e);
            resetTableData();  
        
               TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Supprimé un Sponsor");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
    }
        
        
        
    }

    @FXML
    private void Modif(ActionEvent event) throws IOException {
              SponsorsCRUD ps = new SponsorsCRUD();
        Sponsors c = new Sponsors(tableview.getSelectionModel().getSelectedItem().getID_Sponsor(),
                tableview.getSelectionModel().getSelectedItem().getNom_Sponsor(),
                tableview.getSelectionModel().getSelectedItem().getPrenom_Sponsor(),
                 tableview.getSelectionModel().getSelectedItem().getMontant(),
                tableview.getSelectionModel().getSelectedItem().getDuree_spons()
               
                
                );
        AfficherSponsorsController.connectedSponsor = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ModifierSponsor.fxml"));
        Scene scene = new Scene(page1, 1144, 741);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        
               Parent page1 = FXMLLoader.load(getClass().getResource("AjouterSponsor.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Evenements");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void spon(ActionEvent event) throws IOException {
               Parent page1 = FXMLLoader.load(getClass().getResource("AfficherSponsors.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Evenements");
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void budg(ActionEvent event) throws IOException {
          Parent page1 = FXMLLoader.load(getClass().getResource("AfficherBudget.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Evenements");
        stage.setScene(scene);
        stage.show();  
        
        
    }
        
        
    }
    
    
    
    
