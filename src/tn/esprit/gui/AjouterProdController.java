/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.scene.*;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.*;
import tn.esprit.entities.Produit;
import tn.esprit.services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ramyc
 */
public class AjouterProdController implements Initializable {

    @FXML
    private TextField tfnomprod;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfmarque;
    @FXML
    private TextField tfquanprod;
    @FXML
    private TextField tfprix;
    @FXML
    private Button btnajouterprod;
    @FXML
    private Button btnsuppproduit;
    @FXML
    private Button btnmodifprod;
    @FXML
    private TableView<Produit> tableprod;
    @FXML
    private TableColumn<Produit, Integer> cprod;
    @FXML
    private TableColumn<Produit, String> cmarque;
    @FXML
    private TableColumn<Produit, String> cnom;
    @FXML
    private TableColumn<Produit, Integer> cquanprod;
    @FXML
    private TableColumn<Produit, Integer> cprix;
    @FXML
    private TableColumn<Produit, String> ctype;
        @FXML
    public static int idtomodif=0;
    //public ObservableList<Produit> dataprod = FXCollections.observableArrayList(ps.afficher());
    
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProduitService ps = new ProduitService();
        ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
        cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
        cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
        cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
        cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        tableprod.setItems(dataprodd);
    }    

    
    

    @FXML
    private void saveProd(ActionEvent event) {
        ProduitService ps = new ProduitService();
        Produit p = new Produit();
        p.setMarque(tfmarque.getText());
        p.setType(tftype.getText());
        p.setNom(tfnomprod.getText());
        p.setQuantite(Integer.parseInt(tfquanprod.getText()));
        p.setPrix(Integer.parseInt(tfprix.getText()));
        ps.ajouterPst(p);
        
        ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
        cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
        cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
        cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
        cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        tableprod.setItems(dataprodd);
    }
    
    @FXML
    private void deleteProd(ActionEvent event) {
        ProduitService ps = new ProduitService();
        if (tableprod.getSelectionModel().getSelectedItem() != null) {
            Produit p = tableprod.getSelectionModel().getSelectedItem();
            ps.supprimer(p.getProductId());
        }

        
        ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
        cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
        cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
        cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
        cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        tableprod.setItems(dataprodd);
    }
    
    @FXML
    private void openmodif(ActionEvent event) {
        ProduitService ps = new ProduitService();
        if (tableprod.getSelectionModel().getSelectedItem() != null) {
            Produit p = tableprod.getSelectionModel().getSelectedItem();
            idtomodif = p.getProductId();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifProd.fxml"));
            try {
                Parent root1 = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Modifier Produit");
                stage.setScene(new Scene(root1, 600, 500));
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
