/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.crud.BudgetCRUD;
import edu.esprit.crud.SponsorsCRUD;
import edu.esprit.entities.Sponsors;
import edu.esprit.entities.budget;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
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
public class AfficherBudgetController implements Initializable {

    @FXML
    private TextField inputRech;
    @FXML
    private Button supp;
    @FXML
    private Button supp1;
    @FXML
    private Button Ajouter;
    @FXML
    private TableView<budget> tableview;
    private TableColumn<budget, ?> ID_Budget;
    @FXML
    private TableColumn<budget, ?> Montant;
    @FXML
    private TableColumn<budget, ?> Activite;
    @FXML
    private TableColumn<budget, ?> Sponsor;
 public ObservableList<budget> list;
  public static budget connectedbudget;
  BudgetCRUD cs = new BudgetCRUD();
    @FXML
    private Hyperlink spon;
    @FXML
    private Hyperlink budg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         BudgetCRUD pss = new BudgetCRUD();
        ArrayList<budget> c = new ArrayList<>();
        c = (ArrayList<budget>) pss.AfficherBudget();
        
        ObservableList<budget> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
    //    ID_Budget.setCellValueFactory(new PropertyValueFactory<>("ID_Budget"));
 Activite.setCellValueFactory(new PropertyValueFactory<>("Activite"));
        Sponsor.setCellValueFactory(new PropertyValueFactory<>("ID_Sponsor"));
        Montant.setCellValueFactory(new PropertyValueFactory<>("Montant"));
        
             
            try {
            list = FXCollections.observableArrayList(
                    pss.AfficherBudget()
            );     
        
         FilteredList<budget> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super budget>) budgets -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (budgets.getActivite().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<budget> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
   public void resetTableData() throws SQLDataException, SQLException {

        List<budget> listbudget = new ArrayList<>();
        listbudget = cs.AfficherBudget();
        ObservableList<budget> data = FXCollections.observableArrayList(listbudget);
        tableview.setItems(data);
    }   
    @FXML
    private void supp(ActionEvent event) throws SQLException {
               if (event.getSource() == supp) {
            budget e = new budget();
            e.setID_Budget(tableview.getSelectionModel().getSelectedItem().getID_Budget());  
            BudgetCRUD cs = new BudgetCRUD();
            cs.SupprimerUser(e);
            resetTableData();  
        
               TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Vous avez Supprimé un budget ");
            tray.setMessage("");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        
    }
        
        
    }

    @FXML
    private void Modif(ActionEvent event) throws IOException {
        
        
            BudgetCRUD ps = new BudgetCRUD();
        budget c = new budget(tableview.getSelectionModel().getSelectedItem().getID_Budget(),
                tableview.getSelectionModel().getSelectedItem().getMontant(),
                tableview.getSelectionModel().getSelectedItem().getActivite(),
                 tableview.getSelectionModel().getSelectedItem().getSponsors()
                
               
                
                );
        AfficherBudgetController.connectedbudget = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ModifierBudget.fxml"));
        Scene scene = new Scene(page1, 1144, 741);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
               Parent page1 = FXMLLoader.load(getClass().getResource("AjouterBudget.fxml"));
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
    private void budg(ActionEvent event) {
        
    }
    
}
