package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) {
        Button button = new Button("I'm a button frfr");
        Label label = new Label("I'm a label and I label stuff");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(label);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }
}
