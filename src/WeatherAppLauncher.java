/*
 * WeatherAppLauncher
 * Name: Cohen Gallagher
 * Date: 5/2/2025
 * Class: Programming in Java
 * Description: Launches FXML file.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WeatherAppLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/WeatherProgramUI.fxml"));
            Parent root = loader.load();

            // Create Scene
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Weather Program");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(
                    new Image(getClass().getResource("/Images/favicon.png").toExternalForm())
            );
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Launch
    public static void main(String[] args) {
        launch(args);
    }
}