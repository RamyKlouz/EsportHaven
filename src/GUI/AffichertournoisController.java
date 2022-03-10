/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Tournois;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.TournoisService;
import utils.Mail;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichertournoisController implements Initializable {
TournoisService st = new TournoisService();
    @FXML
    private TableView<Tournois> tvtournoi;
    @FXML
    private TableColumn<Tournois, Integer> id;
    @FXML
    private TableColumn<Tournois, String> nom;
    @FXML
    private TableColumn<Tournois, Integer> nbequipe;
    @FXML
    private TableColumn<Tournois, Date> daedebut;
    @FXML
    private TableColumn<Tournois, String> jeux;
    @FXML
    private TableColumn<Tournois, Date> datefin;
    @FXML
    private TableColumn<Tournois, String> action;
    @FXML
    private Button ajouter;
    @FXML
    private Label nomtop;
    @FXML
    private JFXTextField searchComBox;

    
    
     public boolean clickkk(MouseEvent event){

             TablePosition tableposition = tvtournoi.getSelectionModel().getSelectedCells().get(0);
             int row = tableposition.getRow();
             int col = tableposition.getColumn();
             if (col == 0){
             Tournois tournois = tvtournoi.getItems().get(0);
             TableColumn tablecolumn = tableposition.getTableColumn();
             String data = (String) tablecolumn.getCellObservableValue(tournois).getValue();
             System.out.println(data);
             return true ; 
             }else return false ; 

        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          
        // TODO
                ObservableList<Tournois> ltournois;      

         ltournois =  st.afficherobserv();  
        
        id.setCellValueFactory(new PropertyValueFactory<Tournois, Integer>("id"));
         nom.setCellValueFactory(new PropertyValueFactory<Tournois, String>("nom"));
         nbequipe.setCellValueFactory(new PropertyValueFactory<Tournois, Integer>("nb_equipes"));
         daedebut.setCellValueFactory(new PropertyValueFactory<Tournois, Date>("date_deb"));
         datefin.setCellValueFactory(new PropertyValueFactory<Tournois, Date>("date_fin"));
         jeux.setCellValueFactory(new PropertyValueFactory<Tournois, String>("jeux"));
         
         Callback<TableColumn<Tournois, String>, TableCell<Tournois, String>> cellFoctory;
            cellFoctory = (TableColumn<Tournois, String> param) -> {
                // make cell containing buttons
                final TableCell<Tournois, String> cell;
                cell = new TableCell<Tournois, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //that cell created only on non-empty rows
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                            
                        } else {
                            
                            FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                            FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                            
                            deleteIcon.setStyle(
                                    " -fx-cursor: hand ;"
                                            + "-glyph-size:28px;"
                                            + "-fx-fill:#ff1744;"
                            );
                            editIcon.setStyle(
                                    " -fx-cursor: hand ;"
                                            + "-glyph-size:28px;"
                                            + "-fx-fill:#00E676;"
                            );
                             //Topic topic = tvtopics.getSelectionModel().getSelectedItem();
                            deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                                
                               
Tournois tournoi = tvtournoi.getSelectionModel().getSelectedItem();
//                                st.supprimer(topic.getIdtopic());
//                                tvtopics.refresh();

                                    
                  
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer ce topic  ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            st.supprimer(tournoi.getId());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText(null);
            alert.setContentText(" Done!");
            alert.show();
             System.out.println("attention");
                 Mail.envoyer("islem.zouari@esprit.tn");
            tvtournoi.setItems(st.afficherobserv());

        } else {
            alert2.close();
        }
                                
                                
                                
                                
                                
 
 
                            });
                            
                            editIcon.setOnMouseClicked((MouseEvent event) -> {
                              Tournois tournoi = tvtournoi.getSelectionModel().getSelectedItem();
                                    System.out.println(tournoi);
                               
                                   
                                   FXMLLoader loader = new FXMLLoader ();
                                    loader.setLocation(getClass().getResource("/GUI/modifiertournoi.fxml"));
                                 try {   loader.load();
                                    } catch (IOException ex) {
                                    Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ModifiertournoiController.tournoi=tournoi;
                                    Parent parent = loader.getRoot();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(parent));
                                    stage.initStyle(StageStyle.UTILITY);
                                    stage.show();
                                     stage.setOnHiding( event2 -> { tvtournoi.setItems(st.afficherobserv());});
                                  new animatefx.animation.ZoomIn(parent).play();
                                    
                                   
                               
              
                                
                            
                        });
                            
                            HBox managebtn = new HBox(editIcon, deleteIcon);
                            managebtn.setStyle("-fx-alignment:center");
                            HBox.setMargin(deleteIcon, new Insets(0, 0, 0, 0));
                            HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
                            setGraphic(managebtn);
                            setText(null);
                            
                        }
                    }
                    
                };
                
                return cell;
            };
            
                        
            action.setCellFactory(cellFoctory);
            

         
         
        tvtournoi.setItems(ltournois);
        
    }    

    

@FXML
    private void ajoutertournois(ActionEvent event) {
        try {
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/AjouterTournois.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        
        stage.setOnHiding( event2 -> { tvtournoi.setItems(st.afficherobserv());});
                                          new animatefx.animation.ZoomIn(parent).play();

    } catch (IOException ex) {
        Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void toptour(MouseEvent event) {
    Tournois tournoi=st.toptour();
    nomtop.setText(tournoi.getNom());
    tvtournoi.setItems(st.afficherobserv());
    }

    @FXML
    private void searchEvent(KeyEvent event) {
         if ((searchComBox.getText().trim().equals(""))) {
             tvtournoi.setItems(st.afficherobserv());
        } else {
         tvtournoi.setItems(st.afficherobserv(searchComBox.getText().trim()));
         }
    }

}
