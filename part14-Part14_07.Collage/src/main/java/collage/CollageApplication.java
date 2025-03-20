package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {
        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        ImageView image = createSplitImage(sourceImage);

        Pane pane = new Pane(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ImageView createSplitImage(Image sourceImage) {
        PixelReader sourceImageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height); // Resulting image after we transform the original
        PixelWriter imageWriter = targetImage.getPixelWriter();

        for (int i = 0; i < 4; i++) { // Runs a for loop for each quadrant of the new image
            int sourceYCoordinate = 0;
            int imageYCoordinate = 0;

            if (i == 2 || i == 3) { // Changes the y coordinates so the image is on the bottom
                imageYCoordinate = height / 2;
            }

            while (sourceYCoordinate * 2 < height) { // Multiply the coords by 2 so that it compresses the image
                int sourceXCoordinate = 0;
                int imageXCoordinate = 0;

                if (i == 1 || i == 3) { // Changes the x coordinates so the image is on the right side
                    imageXCoordinate = (width / 2);
                }

                while (sourceXCoordinate * 2 < width) {
                    Color color = sourceImageReader.getColor(sourceXCoordinate * 2, sourceYCoordinate * 2);
                    // Transforming the color values to their negatives by subtracting it with 1
                    double red = 1 - color.getRed();
                    double green = 1 - color.getGreen();
                    double blue = 1 - color.getBlue();
                    double opacity = color.getOpacity();

                    Color newColor = new Color(red, green, blue, opacity);

                    imageWriter.setColor(imageXCoordinate, imageYCoordinate, newColor);

                    sourceXCoordinate++;
                    imageXCoordinate++;
                }
                sourceYCoordinate++;
                imageYCoordinate++;
            }
        }

        return new ImageView(targetImage);
    }
}