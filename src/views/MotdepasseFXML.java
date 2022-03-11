/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Objects;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 21654
 */
public class MotdepasseFXML extends Application {
    

    Parent parent;
    Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        this.stage=primaryStage;
        try {
            parent = FXMLLoader.load(Objects.requireNonNull(HomeUserFXLM.class.getResource("/resources/MotdepasseFXML.fxml")));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Oublie");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    
}
