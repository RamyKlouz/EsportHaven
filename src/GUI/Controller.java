package GUI;

import GUI.Joueur;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
//import tray.animations.AnimationType;
//import tray.notification.NotificationType;
//import tray.notification.TrayNotification;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;

public class Controller implements Initializable {

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfNbr;

    @FXML
    private TableView<Equipe> tvequipe;

    @FXML
    private TableColumn<Equipe, Integer> colID;

    @FXML
    private TableColumn<Equipe, String> colNom;

    @FXML
    private TableColumn<Equipe, String> colNbr;


    @FXML
    private Button btninsert;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btninsert) {
            insertRecord();
        } else if (event.getSource() == btnupdate) {
            update();
        } else if (event.getSource() == btndelete) {
            delete();
        }

    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/haven", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Equipe> getEquipeList() {
        ObservableList<Equipe> equipeList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM equipe";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Equipe equipe;
            while (rs.next()) {
                equipe = new Equipe(rs.getInt("id"), rs.getString("nom"), rs.getString("nbrJoueur"));
                equipeList.add(equipe);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return equipeList;
    }

    public void showEquipe() {
        ObservableList<Equipe> list = getEquipeList();
        colID.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nom"));
        colNbr.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nbrJoueur"));

        tvequipe.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showEquipe();
    }
int Max=10000000; int Min=1;
int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));

    private void insertRecord() throws IOException {
           if(tfNbr.getText().equals("")||tfNom.getText().equals("")){
                 Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/alertPost.fxml")));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
           }
           else{
        String query = "INSERT INTO equipe VALUES(" + nombreAleatoire + ",'" + tfNom.getText() + "','" + tfNbr.getText() + "')";
        executeQuery(query);
//        TrayNotification tray = new TrayNotification();
//        AnimationType type = AnimationType.POPUP;
//        tray.setAnimationType(type);
//        String tilte = "Equipe Ajouté";
//        String message ="Equipe bien ajouté";
//        tray.setTitle(tilte);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.millis(2000));
        showEquipe();
           }
    }


    private void update() throws IOException {
         if(tfNbr.getText().equals("")||tfNom.getText().equals("")){
                 Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/alertPost.fxml")));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
           }
         else{
        String query = "UPDATE equipe SET nom='" + tfNom.getText() + "',nbrJoueur='" + tfNbr.getText()
                + "' WHERE id = " + tfid.getText() + "";
        executeQuery(query);
//        TrayNotification tray = new TrayNotification();
//        AnimationType type = AnimationType.POPUP;
//        tray.setAnimationType(type);
//        String tilte = "update Success";
//        String message =" Equipe modifié";
//        tray.setTitle(tilte);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.millis(2000));
        showEquipe();
    }
    }
    private void delete() {
        String query = "DELETE FROM equipe WHERE id =" + tfid.getText() + "";
        executeQuery(query);
//        TrayNotification tray = new TrayNotification();
//        AnimationType type = AnimationType.POPUP;
//        tray.setAnimationType(type);
//        String tilte = "Delete Success";
//        String message ="Facture Is Deleted";
//        tray.setTitle(tilte);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.millis(2000));
        showEquipe();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void SignupOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/JoueurInterface.fxml")));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    public void mousebtn(MouseEvent event) {
        Equipe u= tvequipe.getSelectionModel().getSelectedItem();
        tfid.setText(""+u.getId());
        tfNom.setText(u.getNom());
        tfNbr.setText(u.getNbrJoueur());


    }


    //////////pdf

    @FXML
    void PDF(ActionEvent event) throws DocumentException {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\furyj\\Desktop\\test.pdf"));
            doc.open();

            Paragraph p = new Paragraph("*Equipe* ");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);


            Paragraph contenu = new Paragraph(preparerMsg());
            doc.add(contenu);
            doc.close();


            Desktop.getDesktop().open(new File("C:\\Users\\furyj\\Desktop\\test.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Equipe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(Equipe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Equipe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private String preparerMsg() {
        Equipe f = tvequipe.getSelectionModel().getSelectedItem();
        String ch = " \n \n"
                + "Id Equipe: " + f.getId() + "\n \n"

                + "Nom Equipe: " + f.getNom() + "\n \n";


        return ch;
    }

    @FXML
    private void back(ActionEvent event) {
            Stage stage1 = (Stage) tvequipe.getScene().getWindow();
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

    @FXML
    private void logout(ActionEvent event) {
                               Stage stage1 = (Stage) tvequipe.getScene().getWindow();
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

    /*******************************************/

}
