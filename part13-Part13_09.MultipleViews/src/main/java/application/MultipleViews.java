package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();

        Button firstButton = new Button("To the second view!");

        borderPane.setTop(new Label("First view!"));
        borderPane.setCenter(firstButton);

        Scene firstScene = new Scene(borderPane);

        stage.setScene(firstScene);

        Button secondButton = new Button("To the third view!");

        vBox.getChildren().add(secondButton);
        vBox.getChildren().add(new Label("Second view!"));

        Scene secondScene = new Scene(vBox);
        
        Button thirdButton = new Button("To the first view!");

        gridPane.add(new Label("Third view!"), 0, 0);
        gridPane.add(thirdButton, 1, 1);

        Scene thirdScene = new Scene(gridPane);

        // button actions
        firstButton.setOnAction((event) -> {
            stage.setScene(secondScene);
        });

        secondButton.setOnAction((action) -> {
            stage.setScene(thirdScene);
        });

        thirdButton.setOnAction((action) -> {
            stage.setScene(firstScene);
        });

        stage.setTitle("Multiple Views");
        stage.show();
    }
}
