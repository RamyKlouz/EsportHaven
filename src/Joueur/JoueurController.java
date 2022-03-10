package Joueur;

import Joueur.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
//import tray.animations.AnimationType;
//import tray.notification.NotificationType;
//import tray.notification.TrayNotification;
//

public class JoueurController implements Initializable {

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfLast;

    @FXML
    private TextField tfMail;

    @FXML
    private TextField tfPass;
    @FXML
    private TextField filtrage;


    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfBir;


    @FXML
    private TableView<Joueur> tvser;

    @FXML
    private TableColumn<Joueur, Integer> colID;

    @FXML
    private TableColumn<Joueur, String> colName;

    @FXML
    private TableColumn<Joueur, String> colLast;

    @FXML
    private TableColumn<Joueur, String> colMail;

    @FXML
    private TableColumn<Joueur, String> colBir;

    @FXML
    private TableColumn<Joueur, String> colGender;

    @FXML
    private TableColumn<Joueur, String> colRole;

    @FXML
    private TableColumn<Joueur, Integer> colPhone;


    @FXML
    private ComboBox tfGender;


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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noname", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Joueur> getserList() {
        ObservableList<Joueur> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM joueur";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Joueur joueur;
            while (rs.next()) {
                joueur = new Joueur(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("lastname"), rs.getString("email"), rs.getString("gender"), rs.getInt("phone"), rs.getString("birthday"));
                bookList.add(joueur);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    public void showser() {
        ObservableList<Joueur> list = getserList();
        colID.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Joueur, String>("name"));
        colLast.setCellValueFactory(new PropertyValueFactory<Joueur, String>("lastname"));
        colMail.setCellValueFactory(new PropertyValueFactory<Joueur, String>("email"));
        colGender.setCellValueFactory(new PropertyValueFactory<Joueur, String>("gender"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("phone"));
        colBir.setCellValueFactory(new PropertyValueFactory<Joueur, String>("birthday"));

        tvser.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showser();
        search_joueur();
        ObservableList<String> list1 = FXCollections.observableArrayList("Male", "Female");
        tfGender.setItems(list1);
    }

    String Gender;

    @FXML
    void Select(ActionEvent event) {
        Gender = tfGender.getSelectionModel().getSelectedItem().toString();
    }


    private void insertRecord() throws IOException {
        
                  if(tfMail.getText().equals("")||tfLast.getText().equals("")||tfName.getText().equals("")||tfPass.getText().equals("")||tfPhone.getText().equals("")){
                 Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/alertPost.fxml")));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
           }
        int Max=10000000; int Min=1;
        int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));
        String query = "INSERT INTO joueur VALUES(" + nombreAleatoire + ",'" + tfName.getText() + "','" + tfLast.getText() + "','" + tfMail.getText() + "','" + tfPass.getText() + "','" + Gender + "'," + tfPhone.getText() + ",'" + tfBir.getText() + "')";
        executeQuery(query);
//        TrayNotification tray = new TrayNotification();
//        AnimationType type = AnimationType.POPUP;
//        tray.setAnimationType(type);
//        String tilte = "Ajout Joueur";
//        String message ="Joueur Ajouté";
//        tray.setTitle(tilte);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.millis(2000));
        showser();
    }

    private void update() throws IOException {

         if(tfMail.getText().equals("")||tfLast.getText().equals("")||tfName.getText().equals("")||tfPass.getText().equals("")||tfPhone.getText().equals("")){
                 Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/alertPost.fxml")));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
           }
         else{
         
        String query = "UPDATE joueur SET name='" + tfName.getText() + "',lastname='" + tfLast.getText() + "',email='" + tfMail.getText() + "',password='" + tfPass.getText() + "',gender='" + Gender + "',phone=" + tfPhone.getText() + ",birthday='" + tfBir.getText()
                + "' WHERE id = " + tfid.getText() + "";
        executeQuery(query);
//        TrayNotification tray = new TrayNotification();
//        AnimationType type = AnimationType.POPUP;
//        tray.setAnimationType(type);
//        String tilte = "Update Success";
//        String message ="Joueur modifié";
//        tray.setTitle(tilte);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.millis(2000));
        showser();
    }
    }

    private void delete() {
        String query = "DELETE FROM joueur WHERE id ="+tfid.getText() + "";
        executeQuery(query);
//        TrayNotification tray = new TrayNotification();    // notification
//        AnimationType type = AnimationType.POPUP;
//        tray.setAnimationType(type);
//        String tilte = "Delete Success";
//        String message ="Joueur Is Deleted";
//        tray.setTitle(tilte);
//        tray.setMessage(message);
//        tray.setNotificationType(NotificationType.SUCCESS);
//        tray.showAndDismiss(Duration.millis(2000));
        showser();
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
        //// recherche
    void search_joueur() {
        ObservableList<Joueur> list = getserList();
        colID.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Joueur, String>("name"));
        colLast.setCellValueFactory(new PropertyValueFactory<Joueur, String>("lastname"));
        colMail.setCellValueFactory(new PropertyValueFactory<Joueur, String>("email"));
        colGender.setCellValueFactory(new PropertyValueFactory<Joueur, String>("gender"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("phone"));
        colBir.setCellValueFactory(new PropertyValueFactory<Joueur, String>("birthday"));
        tvser.setItems(list);

        FilteredList<Joueur> filteredList = new FilteredList<>(list, b -> true);
        filtrage.textProperty().addListener(((observableValue, oldValue, newValue) ->
        {
            filteredList.setPredicate(joueur ->
            {
                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(joueur.getId()).indexOf(lowerCaseFilter) != -1) {
                    return true;


                } else if (joueur.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (joueur.getGender().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (joueur.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (joueur.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;


                } else if (String.valueOf(joueur.getPhone()).indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else
                    return false;


            });
        }));

        SortedList<Joueur> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tvser.comparatorProperty());
        tvser.setItems(sortedList);

    }

    // selection
    @FXML
    public void mousebtn(MouseEvent event) {
        Joueur u= tvser.getSelectionModel().getSelectedItem();
        tfid.setText(""+u.getId());
        tfName.setText(u.getName());
        tfLast.setText(u.getEmail());
        tfMail.setText(""+u.getLastname());
        tfPass.setText(""+u.getPassword());
        tfPhone.setText(""+u.getPhone());
                tfBir.setText(""+u.getBirthday());


    }


}