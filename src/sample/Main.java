package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
               // Parent root = FXMLLoader.load(getClass().getResource("/sample/JoueurInterface.fxml"));

        primaryStage.setTitle("Espace Equipe");
        primaryStage.setScene(new Scene(root, 900, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}