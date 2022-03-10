package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AjouterCompteFXML extends Application {
Stage stage;
Parent parent;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage=primaryStage;
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/AjouterCompteFXML.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Ajouter Compte");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
