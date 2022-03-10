package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class CreateAccountFXML extends Application {
    Stage stage;
    Parent parent;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage=primaryStage;

        try {
            parent = FXMLLoader.load(Objects.requireNonNull(CreateAccountFXML.class.getResource("/CreateAcFXML.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Creer un nouveau compte ");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
