package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox row = new HBox();
        TextArea textArea = new TextArea();

        Label letterCount = new Label();
        Label wordCount = new Label();
        Label longestWord = new Label();

        row.getChildren().addAll(letterCount, wordCount, longestWord);

        // reads the changes in the text and updates the field
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            // splits the words by whitespace and stores it in an array
            String[] words = newValue.split(" ");

            int numOfWord = words.length;

            if (newValue.isEmpty()) {
                numOfWord = 0; // Sets the wordCount to 0 if the field is empty
            }

            // letterCount
            int numOfLetter = newValue.length();

            String longest = Arrays.stream(words)
                    .sorted((s1, s2) -> s2.length() - s1.length()) // sorts the array in words in descending order
                    .findFirst() // finds the First element, which is the largest because it's sorted
                    .orElse(null); // returns the largest word, and returns null if empty


            // updates the letterCount, wordCount, and longestWord
            letterCount.setText("Letters: " + numOfLetter);
            wordCount.setText("Words: " + numOfWord);
            longestWord.setText("The longest word is: " + longest);
        });

        layout.setCenter(textArea);


        layout.setBottom(row);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }
}
