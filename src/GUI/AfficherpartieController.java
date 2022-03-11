/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Partie;
import entities.Tournois;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.PartieService;

/**
 * FXML Controller class
 *
 * @author Firas CHKOUNDALI
 */
public class AfficherpartieController implements Initializable {
    PartieService sp= new PartieService();
    @FXML
    private Button ajouter;
    @FXML
    private TableColumn<Partie, Integer> id;
    @FXML
    private TableColumn<Partie, Float> duree;
    @FXML
    private TableColumn<Partie, Date> deteder;
    @FXML
    private TableColumn<Partie, Integer> idtournoi;
    @FXML
    private TableColumn<Partie, Integer> score1;
    @FXML
    private TableColumn<Partie, Integer> score2;
    @FXML
    private TableColumn<Partie, Integer> idequipe1;
    @FXML
    private TableColumn<Partie, Integer> idequipe2;
    @FXML
    private TableColumn<Partie, String> editcol;
    @FXML
    private TableView<Partie> tvpartie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ObservableList<Partie> lpartie;      

         lpartie =  sp.afficherobserv();  
         id.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("idPartie"));
         duree.setCellValueFactory(new PropertyValueFactory<Partie, Float>("duree"));
         deteder.setCellValueFactory(new PropertyValueFactory<Partie, Date>("date_deroul"));
         idtournoi.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("id_tournoi"));
         score1.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("score1"));
         score2.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("score2"));
         idequipe1.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("id_equipe1"));
         idequipe2.setCellValueFactory(new PropertyValueFactory<Partie, Integer>("id_equipe2"));
        Callback<TableColumn<Partie, String>, TableCell<Partie, String>> cellFoctory;
            cellFoctory = (TableColumn<Partie, String> param) -> {
                // make cell containing buttons
                final TableCell<Partie, String> cell;
                cell = new TableCell<Partie, String>() {
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
                                
                               
Partie partie = tvpartie.getSelectionModel().getSelectedItem();
//                                st.supprimer(topic.getIdtopic());
//                                tvtopics.refresh();

                                    
                  
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("voulez vous supprimer ce topic  ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            sp.suppPartie(partie.getIdPartie());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText(null);
            alert.setContentText(" Done!");
            alert.show();
            tvpartie.setItems(sp.afficherobserv());

        } else {
            alert2.close();
        }
                                
                                
                                
                                
                                
 
 
                            });
                            
                            editIcon.setOnMouseClicked((MouseEvent event) -> {
                              Partie partie = tvpartie.getSelectionModel().getSelectedItem();
                                    System.out.println(partie);
                               
                                   
                                   FXMLLoader loader = new FXMLLoader ();
                                    loader.setLocation(getClass().getResource("/GUI/modifierpartie.fxml"));
                                 try {   loader.load();
                                    } catch (IOException ex) {
                                    Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ModifierpartieController.partie=partie;
                                    Parent parent = loader.getRoot();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(parent));
                                    stage.initStyle(StageStyle.UTILITY);
                                    stage.show();
                                   new animatefx.animation.ZoomIn(parent).play();
                                    
                                   stage.setOnHiding( event2 -> { tvpartie.setItems(sp.afficherobserv());});
                               
              
                                
                            
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
            
                        
            editcol.setCellFactory(cellFoctory);
            

         tvpartie.setItems(lpartie);
    }    

    @FXML
    private void ajouterpartie(ActionEvent event) {
        try {
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/Ajouterpartie.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        
        stage.setOnHiding( event2 -> { tvpartie.setItems(sp.afficherobserv());});
    } catch (IOException ex) {
        Logger.getLogger(AffichertournoisController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void back(ActionEvent event) {
        Stage stage1 = (Stage) tvpartie.getScene().getWindow();
                      stage1.close();  
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/GUI/menu.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                 new animatefx.animation.ZoomIn(page1).play();

            } catch (IOException ex) {
                Logger.getLogger(AfficherpartieController.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
        
    }
    

