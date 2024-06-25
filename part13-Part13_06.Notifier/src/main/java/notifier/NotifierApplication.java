package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {

        TextField input = new TextField();
        Button button = new Button("Update");
        Label output = new Label();

        VBox col = new VBox();

        col.getChildren().add(input);
        col.getChildren().add(button);
        col.getChildren().add(output);

        button.setOnAction(actionEvent -> output.setText(input.getText()));

        Scene view = new Scene(col, 200, 100);

        window.setScene(view);
        window.show();
    }
}
