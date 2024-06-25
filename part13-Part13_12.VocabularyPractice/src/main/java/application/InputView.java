package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {

    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word");
        TextField wordField = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addToDictButton = new Button("Add the word pair");

        layout.add(wordLabel, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(addToDictButton, 0, 4);

        addToDictButton.setOnMouseClicked(e -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            this.dictionary.add(word, translation);

            wordField.clear();
            translationField.clear();
        });

        return layout;
    }
}