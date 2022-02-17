package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

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
    void handleButtonAction( ActionEvent event) {
        if(event.getSource()== btninsert){
            insertRecord();
        } else if (event.getSource()==btnupdate){
            update();
        }
        else if (event.getSource()==btndelete){
            delete();
        }

    }
    public Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noname","root","");
            return conn;
        }catch (Exception ex ){
            System.out.println("Error :"+ex.getMessage());
            return null;
        }
    }
    public ObservableList<Equipe> getEquipeList(){
        ObservableList<Equipe> equipeList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM equipe";
        Statement st;
        ResultSet rs;
        try {
            st= conn.createStatement();
            rs =st.executeQuery(query);
            Equipe equipe;
            while (rs.next()){
                equipe =new Equipe(rs.getInt("id"), rs.getString("nom"),rs.getString("nbrJoueur") );
                equipeList.add(equipe);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return equipeList;
    }
    public void showEquipe(){
        ObservableList<Equipe> list =getEquipeList();
        colID.setCellValueFactory(new PropertyValueFactory<Equipe,Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Equipe,String>("nom"));
        colNbr.setCellValueFactory(new PropertyValueFactory<Equipe,String>("nbrJoueur"));

        tvequipe.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showEquipe();
    }




    private void insertRecord(){
        String query ="INSERT INTO equipe VALUES("+ tfid.getText()+",'"+ tfNom.getText() +"','"+tfNbr.getText()+"')";
        executeQuery(query);
        showEquipe();
    }





    private void update(){
        String query = "UPDATE equipe SET nom='"+tfNom.getText()+"',nbrJoueur='"+tfNbr.getText()
               +"' WHERE id = "+tfid.getText()+"";
        executeQuery(query);
        showEquipe();
    }
    private void delete(){
        String query ="DELETE FROM equipe WHERE id ="+tfid.getText()+"";
        executeQuery(query);
        showEquipe();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st =conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
