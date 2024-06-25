package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane layout = new GridPane();

        TextField nameField = new TextField();
        Button startButton = new Button("Start");


        layout.add(new Label("Enter your name and start."), 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(startButton, 0, 2);

        layout.setAlignment(Pos.CENTER);

        Scene firstView = new Scene(layout);

        BorderPane welcomeLayout = new BorderPane();

        startButton.setOnAction((action) -> {
            String name = nameField.getText();

            welcomeLayout.setCenter(new Label("Welcome " + name + "!"));
            stage.setScene(new Scene(welcomeLayout));
        });

        stage.setScene(firstView);
        stage.setTitle("Greeter Program");
        stage.show();
    }

}
