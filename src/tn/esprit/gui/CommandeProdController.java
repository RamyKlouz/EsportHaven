/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import GUI.AffichertournoisController;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.entities.Produit;
import tn.esprit.services.ProduitService;
import javafx.scene.control.ButtonType;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.esprit.entities.Commande;
import tn.esprit.entities.CommandeProduit;
import tn.esprit.services.CPService;
import tn.esprit.services.CommandeService;

/**
 * FXML Controller class
 *
 * @author ramyc
 */
public class CommandeProdController implements Initializable {

    @FXML
    private TableView<CommandeProduit> tablecp;
    @FXML
    private TableColumn<CommandeProduit, String> cnom;
    @FXML
    private TableColumn<CommandeProduit, String> cmarque;
    @FXML
    private TableColumn<CommandeProduit, Integer> cprixtotal;
    @FXML
    private TableColumn<CommandeProduit, Integer> cquanprod;
    @FXML
    private Button validbtn;

    @FXML
    private TableColumn<CommandeProduit, Integer> cprix;
    @FXML
    private Button btnmodifcp;
    /*@FXML
    private Button btnsuppproduit1;
    @FXML
    private Button btnmodifprod1;*/
    @FXML
    private TextField tfrecher1;
    /*@FXML
    private Button btnrecherche1;*/
    @FXML
    private CheckBox check1;
    @FXML
    private TextField limitprix;
    @FXML
    private TextField newquan;
    @FXML
    private ListView<Produit> listview1;
    @FXML
    private TextField quantite2;
    @FXML
    private Button btnajoutprod2;
    CommandeService cs = new CommandeService();
    CommandeService cs1 = new CommandeService();
    Commande c = new Commande("User",0);
    @FXML
    private Button btnrecherche1;
    @FXML
    private Button btnsuppproduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CPService cpp=new CPService();
        cpp.clear();
        cs.ajouterCmd(c);
        // System.out.println(cs.lastid());
        this.update2();
       // System.out.println(cs.RechercheCommande(cs1.lastid()).toString()+"***************");
        ProduitService ps = new ProduitService();
        ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
        listview1.getItems().addAll(dataprodd);
        //listview1 = new ListView<Produit>(dataprodd);
        listview1.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
            @Override
            public ListCell<Produit> call(ListView<Produit> listView) {
                return new CustomListCell();
            }
        });

    }

    public void update2() {
        CPService cs = new CPService();
        ProduitService ps = new ProduitService();
        ObservableList<CommandeProduit> dataprodd = FXCollections.observableArrayList(cs.afficher());
        cnom.setCellValueFactory(new PropertyValueFactory<CommandeProduit, String>("nomp"));

        cmarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        cquanprod.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        cprix.setCellValueFactory(new PropertyValueFactory<CommandeProduit, Integer>("prix"));
        cprixtotal.setCellValueFactory(new PropertyValueFactory<CommandeProduit, Integer>("sommePrix"));
        tablecp.setItems(dataprodd);
    }

    @FXML
    private void ajoutProd22(ActionEvent event) {
        ProduitService ps = new ProduitService();
        CPService cps = new CPService();
        CommandeProduit cp1 = new CommandeProduit();

        if ((listview1.getSelectionModel().getSelectedItem() != null) && (!("".equals(quantite2.getText())))) {
            Produit p = listview1.getSelectionModel().getSelectedItem();
            int qu = Integer.parseInt(quantite2.getText());
            cp1.setProductID(p.getProductId());
            //System.out.println(c.getOrderID());
            //cp1.setOrderID(c.getOrderID());
            cp1.setOrderID(cs.lastid());

            //cp1.setOrderID(14);
            cp1.setQuantite(qu);
            cp1.setSommePrix(p.getPrix() * qu);
            cps.ajouter(cp1);
            
            
            
            Commande newc=new Commande();
            newc.setSomme(cps.somme());
            newc.setClient(c.getClient());
            newc.setOrderID(c.getOrderID());
            cs.modifier(newc,c.getOrderID());
            
            
        }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout");
            alert.setHeaderText(null);
            alert.setContentText("Quantité ajoutée !");
            
            alert.show();


        this.update2();
    }

    @FXML
    private void suppcp(ActionEvent event) {
        CPService ps = new CPService();
        if (tablecp.getSelectionModel().getSelectedItem() != null) {
            CommandeProduit p = tablecp.getSelectionModel().getSelectedItem();
            ps.supprimer(p.getCpID());
        }

        this.update2();

    }

    @FXML
    private void modifcp(ActionEvent event) {
        CPService ps = new CPService();
        ProduitService pp = new ProduitService();
        if ("".equals(newquan.getText()) || tablecp.getSelectionModel().getSelectedItem() == null) {
            System.out.println("dakhel quantité wala selecti cp");
        } else {
            CommandeProduit p = new CommandeProduit();
            CommandeProduit po = tablecp.getSelectionModel().getSelectedItem();
            //p.setCpID(po.getCpID());
            p.setProductID(po.getProductID());
            p.setQuantite(Integer.parseInt(newquan.getText()));
            p.setOrderID(po.getOrderID());
            int newprice = pp.RechercheProduit(po.getProductID()).getPrix() * Integer.parseInt(newquan.getText());
            p.setSommePrix(newprice);
            ps.modifier(p, po.getCpID());

        }

        this.update2();

    }

    @FXML
    private void validercmd(ActionEvent event) {

        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous valider votre commande ? ");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {


            System.out.println(c.getSomme());

        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //System.out.println(cs.RechercheCommande(cs.lastid()).toString()+"***************");
        int a=cs.lastid();
        String myWeb = cs.RechercheCommande(a).toString();
        //String myWeb = "hi";
        int width = 300;
        int height = 300;
        String fileType = "png";
        Commande c = new Commande();
        cs.ajouter(c);
        CPService cs = new CPService();
        cs.clear();
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {
            System.out.println(ex.getMessage());
        }
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 650, 350);
        Stage stage = new Stage();
        stage.setTitle("Validé! Le code de votre Commande : ");
        stage.setScene(scene);
        stage.show();
        this.update2();
        
        
            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Validation");
            alert.setHeaderText(null);
            alert.setContentText("Validé! Votre Commande : ");
            
            alert.show();*/
            //System.out.println("attention");


        } else {
            alert2.close();
        }



    }

    @FXML
    private void chercher(ActionEvent event) {

        if ("".equals(tfrecher1.getText())) {
            System.out.println("1oo");
            ProduitService ps = new ProduitService();
            ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
            listview1.getItems().clear();
            listview1.getItems().addAll(dataprodd);
            //listview1 = new ListView<Produit>(dataprodd);
            listview1.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
                @Override
                public ListCell<Produit> call(ListView<Produit> listView) {
                    return new CustomListCell();
                }
            });

        } else {
            System.out.println("2");
            //ObservableList<Produit> dataprodd2 = FXCollections.observableArrayList(ps.RechercheProd("'" + tfrecher.getText() + "'"));
            System.out.println("1iii");
            ProduitService ps = new ProduitService();
            ObservableList<Produit> dataprodd2 = FXCollections.observableArrayList(ps.RechercheProd("'" + tfrecher1.getText() + "'"));
            listview1.getItems().clear();
            listview1.getItems().addAll(dataprodd2);
            //listview1 = new ListView<Produit>(dataprodd);
            listview1.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
                @Override
                public ListCell<Produit> call(ListView<Produit> listView) {
                    return new CustomListCell();
                }
            });;
        }
    }

    @FXML
    private void showremise(ActionEvent event) {
        if ("".equals(limitprix.getText()) || check1.isSelected()) {
            System.out.println("hiii");
            ProduitService ps = new ProduitService();
            ObservableList<Produit> dataprodd = FXCollections.observableArrayList(ps.afficherObs());
            listview1.getItems().clear();
            listview1.getItems().addAll(dataprodd);
            //listview1 = new ListView<Produit>(dataprodd);
            listview1.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
                @Override
                public ListCell<Produit> call(ListView<Produit> listView) {
                    return new CustomListCell();
                }
            });

        } else {
            System.out.println("2");
            //ObservableList<Produit> dataprodd2 = FXCollections.observableArrayList(ps.RechercheProd("'" + tfrecher.getText() + "'"));
            System.out.println("1iii");
            ProduitService ps = new ProduitService();
            ObservableList<Produit> dataprodd2 = FXCollections.observableArrayList(ps.RechercheProd2(Integer.parseInt(limitprix.getText())));
            listview1.getItems().clear();
            listview1.getItems().addAll(dataprodd2);
            //listview1 = new ListView<Produit>(dataprodd);
            listview1.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
                @Override
                public ListCell<Produit> call(ListView<Produit> listView) {
                    return new CustomListCell();
                }
            });;
        }

    }

    @FXML
    private void back(ActionEvent event) {
                Stage stage1 = (Stage) validbtn.getScene().getWindow();
                      stage1.close();  
                      try {
           
                Parent page1 = FXMLLoader.load(getClass().getResource("/GUI/ClientSide.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                 new animatefx.animation.ZoomIn(page1).play();

            } catch (IOException ex) {
                Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }

    @FXML
    private void logout(ActionEvent event) {
                        Stage stage1 = (Stage) validbtn.getScene().getWindow();
                      stage1.close();  
                      try {
           
                Parent page1 = FXMLLoader.load(getClass().getResource("/resources/HomeUsFXML.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                 new animatefx.animation.ZoomIn(page1).play();

            } catch (IOException ex) {
                Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }

    private class CustomListCell extends ListCell<Produit> {

        private HBox content;
        private Text name;
        private Text price;

        public CustomListCell() {
            super();
            name = new Text();
            price = new Text();

            VBox vBox = new VBox(name, price);
            content = new HBox(new Label("hi"), vBox);
            content.setSpacing(10);
        }

        @Override
        protected void updateItem(Produit item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                name.setText(item.getNom());
                price.setText(String.format("%d D", item.getPrix()));
                VBox vBox2 = new VBox(name, price);
                String sss = "[" + item.getMarque() + "]";
                //content=new HBox(new Label("["+item.getMarque()+"]"), vBox2);
                HBox hi = new HBox(new Label(sss), vBox2);
                hi.setSpacing(180 - ((sss.length()) * 7));
                setGraphic(hi);
            } else {
                setGraphic(null);
            }
        }
    }

}
