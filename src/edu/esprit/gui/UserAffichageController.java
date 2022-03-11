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
import java.sql.SQLException;
import java.util.ArrayList;
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

/**
 * FXML Controller class
 *
 * @author sk4nd
 */
public class UserAffichageController implements Initializable {
    @FXML
    private TextField inputRech;
    @FXML
    private TableView<Sponsors> tableview;
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
        // TODO
        SponsorsCRUD pss = new SponsorsCRUD();
        ArrayList<Sponsors> v = new ArrayList<>();
        try {
            v = (ArrayList<Sponsors>) pss.AfficherSponsors();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherSponsorsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<Sponsors> obs5 = FXCollections.observableArrayList(v);
        tableview.setItems(obs5);
      
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        // TODO
    }       
        @FXML
    private void spon(ActionEvent event) throws IOException {
               Parent page1 = FXMLLoader.load(getClass().getResource("UserAffichage.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Evenements");
        stage.setScene(scene);
        stage.show();
        
        
    }
}
