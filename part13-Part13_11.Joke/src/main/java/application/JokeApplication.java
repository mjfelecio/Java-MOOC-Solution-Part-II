package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane mainLayout = new BorderPane();
        HBox buttonLayout = new HBox();

        // making the jokes
        Label joke = new Label("What do you call a bear with no teeth?");
        Label answer = new Label("A gummy bear.");
        Label explanation = new Label("You can't eat gummy bears if it did have teeth can you?");


        // making the buttons
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        // setting up the buttons
        buttonLayout.getChildren().addAll(jokeButton, answerButton, explanationButton);
        buttonLayout.setAlignment(Pos.TOP_CENTER);
        buttonLayout.setSpacing(20);
        
        // setting up the initial state of the screen
        mainLayout.setTop(buttonLayout);
        mainLayout.setCenter(joke);

        // implementing the button actions
        jokeButton.setOnAction(e -> mainLayout.setCenter(joke));
        answerButton.setOnAction(e -> mainLayout.setCenter(answer));
        explanationButton.setOnAction(e -> mainLayout.setCenter(explanation));

        Scene root = new Scene(mainLayout, 400, 200);

        // setting up the window
        stage.setScene(root);
        stage.setTitle("A Joke Program");
        stage.show();
    }
}
