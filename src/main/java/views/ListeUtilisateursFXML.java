package views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Objects;

public class ListeUtilisateursFXML extends Application {

    Parent parent;
    Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage=primaryStage;
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/ListeUtilisateurs.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Admin");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
