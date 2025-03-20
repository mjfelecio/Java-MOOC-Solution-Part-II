package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(480, 480);
        int rectWidth = 60;
        int rectHeight = 60;

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(120, 60, rectWidth, rectHeight); // Left eye
        graphicsContext.fillRect(300, 60, rectWidth, rectHeight); // Right eye
        graphicsContext.fillRect(60, 240, rectWidth, rectHeight); // Smile start
        graphicsContext.fillRect(120, 300, rectWidth, rectHeight); // Smile line
        graphicsContext.fillRect(180, 300, rectWidth, rectHeight); // Smile line
        graphicsContext.fillRect(240, 300, rectWidth, rectHeight); // Smile line
        graphicsContext.fillRect(300, 300, rectWidth, rectHeight); // Smile line
        graphicsContext.fillRect(360, 240, rectWidth, rectHeight); // Smile end

        root.setCenter(canvas);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
}
