package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Main extends Application{
    RaspiViewController controller;
    BooleanProperty led1State = new SimpleBooleanProperty(false);
    boolean state = false;
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RaspiView.fxml"));
            Scene scene = new Scene(loader.load());
            controller = loader.getController();
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("JFX GPIO - Observer Demo");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
            Platform.exit();
        }

        GPIOPlayer gpio = new GPIOPlayer();
        controller.getLed1Property().bind(gpio.getLed1Property());
        controller.getBtn1Property().bind(gpio.getBtn1Property());
        controller.getBtn2Property().bind(gpio.getBtn2Property());
        controller.getBtnAProperty().bind(gpio.getBtnAProperty());
        controller.getBtnBProperty().bind(gpio.getBtnBProperty());
        controller.getBtnCProperty().bind(gpio.getBtnCProperty());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
