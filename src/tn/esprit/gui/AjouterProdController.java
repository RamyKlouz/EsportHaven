/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.scene.*;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.chart.BarChart;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import tn.esprit.entities.Produit;
import tn.esprit.services.ProduitService;
import tn.esprit.services.CommandeService;
import tn.esprit.entities.Commande;


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
    private Button btnsuppcmd;
    @FXML
    private Button btnmodifcmd;
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
    private TextField tfrecher;
    @FXML
    private CheckBox check;
    @FXML
    private BarChart bc;
    @FXML
    private LineChart lc;
    public static int idtomodif = 0;
    //public ObservableList<Produit> dataprod = FXCollections.observableArrayList(ps.afficher());
    @FXML
    private Button btnrecherche;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.update();
    }

    public void update() {
        ProduitService ps = new ProduitService();
        ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
        cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
        cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
        cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
        cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        tableprod.setItems(dataprodd);
        
        CommandeService cs=new CommandeService();
        

        
        bc.getData().clear();
        lc.getData().clear();
        XYChart.Series series1 = new XYChart.Series();
        //bar chart
        series1.getData().add(new XYChart.Data("Fnatic", ps.compter("Fnatic")));
        series1.getData().add(new XYChart.Data("Cloud 9", ps.compter("Cloud 9")));
        series1.getData().add(new XYChart.Data("G2 Esports", ps.compter("G2 Esports")));
        bc.getData().addAll(series1);
        //line chart
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        for (Produit prod : ps.afficher()) {
            series2.getData().add(new XYChart.Data(prod.getNom(), prod.getQuantite()));
            series3.getData().add(new XYChart.Data(prod.getNom(), prod.getPrix()));
        }
        lc.getData().addAll(series2, series3);
        lc.setPrefHeight(370);
        lc.setMinHeight(370);
        lc.setMaxHeight(400);

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
        
        /*if (tfmarque.getText().equals("") || tftype.getText().equals("") || tfnomprod.getText().equals("")
                || tfquanprod.getText().equals("") || tfprix.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {*/
            ps.ajouterPst(p);
      //  }

        this.update();
        /*    ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
        cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
        cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
        cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
        cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        tableprod.setItems(dataprodd);*/
    }

    @FXML
    private void deleteProd(ActionEvent event) {
        ProduitService ps = new ProduitService();
        if (tableprod.getSelectionModel().getSelectedItem() != null) {
            Produit p = tableprod.getSelectionModel().getSelectedItem();
            ps.supprimer(p.getProductId());
        }

        this.update();
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

    @FXML
    private void chercher(ActionEvent event) {

        ProduitService ps = new ProduitService();
        if ("".equals(tfrecher.getText())) {
            System.out.println("1");
            ObservableList<Produit> dataprodd3 = FXCollections.observableArrayList(ps.afficherObs());
            cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
            cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
            ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
            cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
            cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
            tableprod.setItems(dataprodd3);

        } else {
            System.out.println("2");
            ObservableList<Produit> dataprodd2 = FXCollections.observableArrayList(ps.RechercheProd("'" + tfrecher.getText() + "'"));
            cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
            cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
            ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
            cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
            cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
            tableprod.setItems(dataprodd2);
        }
    }
    @FXML
    private void showremise(ActionEvent event) {

        ProduitService ps = new ProduitService();
        if (check.isSelected()) {
            System.out.println("aa");
            ObservableList<Produit> dataprodd3 = FXCollections.observableArrayList(ps.RechercheProd2(15));
            cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
            cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
            ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
            cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
            cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
            tableprod.setItems(dataprodd3);

        } else {
            System.out.println("1");
            ObservableList<Produit> dataprodd3 = FXCollections.observableArrayList(ps.afficherObs());
            cprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("productId"));
            cnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
            ctype.setCellValueFactory(new PropertyValueFactory<Produit, String>("type"));
            cmarque.setCellValueFactory(new PropertyValueFactory<Produit, String>("marque"));
            cquanprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
            cprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
            tableprod.setItems(dataprodd3);
        }
    }

}
