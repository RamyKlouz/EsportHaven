/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tn.esprit.entities.Produit;
import tn.esprit.services.ProduitService;


/**
 * FXML Controller class
 *
 * @author ramyc
 */
public class ModifProdController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProduitService ps = new ProduitService();
        tfnomprod.setText(ps.RechercheProduit(AjouterProdController.idtomodif).getNom());
        tftype.setText(ps.RechercheProduit(AjouterProdController.idtomodif).getType());
        tfmarque.setText(ps.RechercheProduit(AjouterProdController.idtomodif).getMarque());
        tfquanprod.setText(Integer.toString(ps.RechercheProduit(AjouterProdController.idtomodif).getQuantite()));
        tfprix.setText(Integer.toString(ps.RechercheProduit(AjouterProdController.idtomodif).getPrix()));
    }    

    @FXML
    private void modifProd(ActionEvent event) {
        ProduitService ps = new ProduitService();
        Produit p = new Produit();
        p.setMarque(tfmarque.getText());
        p.setType(tftype.getText());
        p.setNom(tfnomprod.getText());
        p.setQuantite(Integer.parseInt(tfquanprod.getText()));
        p.setPrix(Integer.parseInt(tfprix.getText()));
        ps.modifier(p,AjouterProdController.idtomodif);
        
    }
    
}
