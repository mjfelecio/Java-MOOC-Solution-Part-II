package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsCalculatorApplication extends Application {
    private Slider savingsSlider;
    private Slider interestSlider;
    private LineChart<Number, Number> lineChart;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane rootPane = new BorderPane();
        VBox chartInputGroup = new VBox();

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        BorderPane savingsPane = new BorderPane();
        Label savingsLabel = new Label("Monthly savings");
        savingsSlider = new Slider(25, 250, 25);
        Label savingsValueLabel = new Label(String.valueOf(savingsSlider.getValue()));

        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setBlockIncrement(1);

        savingsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Rounds the number to two decimal places
            BigDecimal decimal = new BigDecimal(newValue.toString());
            double sliderValue = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();

            savingsValueLabel.setText(String.valueOf(sliderValue));

            updateData();
        });

        savingsPane.setLeft(savingsLabel);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsValueLabel);
        savingsPane.setPadding(new Insets(20));

        BorderPane interestPane = new BorderPane();
        Label interestLabel = new Label("Yearly interest rate");
        interestSlider = new Slider(0, 10, 0);
        Label interestValueLabel = new Label(String.valueOf(interestSlider.getValue()));

        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setBlockIncrement(1);

        interestSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Rounds the number to two decimal places
            BigDecimal decimal = new BigDecimal(newValue.toString());
            double sliderValue = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();

            interestValueLabel.setText(String.valueOf(sliderValue));

            updateData();
        });

        interestPane.setLeft(interestLabel);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestValueLabel);
        interestPane.setPadding(new Insets(20));

        // Calculate default values for the line chart
        XYChart.Series<Number, Number> savingsData = createSavingsSeries();
        XYChart.Series<Number, Number> savingsWithInterestData = createSavingsWithInterestSeries();

        // LineChart
        lineChart.getData().add(savingsData);
        lineChart.getData().add(savingsWithInterestData);
        lineChart.setLegendVisible(false);

        // VBox
        chartInputGroup.getChildren().addAll(savingsPane, interestPane);

        // Borderpane
        rootPane.setCenter(lineChart);
        rootPane.setTop(chartInputGroup);

        // Scene
        Scene scene = new Scene(rootPane, 800, 600);

        // Stage
        stage.setScene(scene);
        stage.setTitle("Savings Calculator");
        stage.show();
    }

    private XYChart.Series<Number, Number> createSavingsSeries() {
        XYChart.Series<Number, Number> data = new XYChart.Series<>();

        for (int year = 0; year <= 30; year++) {
            double savingsPerYear = calculateSavings(year);

            data.getData().add(new XYChart.Data<>(year, savingsPerYear));
        }

        return data;
    }

    private XYChart.Series<Number, Number> createSavingsWithInterestSeries() {
        XYChart.Series<Number, Number> data = new XYChart.Series<>();

        for (int year = 0; year <= 30; year++) {
            double savingsPerYear = calculateSavingsWithInterest(year);

            data.getData().add(new XYChart.Data<>(year, savingsPerYear));
        }

        return data;
    }

    public double calculateSavings(int year) {
        double monthlySavings = savingsSlider.getValue();

        return (monthlySavings * 12) * year;
    }

    public double calculateSavingsWithInterest(int year) {
        double monthlySavings = savingsSlider.getValue();
        double yearlySavings = monthlySavings * 12;
        double r = interestSlider.getValue() / 100; // interest rate

        if (r <= 0) return calculateSavings(year);

        double totalSavings = 0;

        for (int i = 1; i <= year; i++) {
            totalSavings = (totalSavings + yearlySavings) * (1 + r);
        }

        return totalSavings;
    }
    
    private void updateData() {
        // Gets the series with no interest applied and updates the data
        XYChart.Series<Number, Number> savingsData = lineChart.getData().get(0);
        for (XYChart.Data<Number, Number> data : savingsData.getData()) {
            for (int year = 0; year <= 30; year++) {
                if (data.getXValue().equals(year)) {
                    double savings = calculateSavings(year);
                    data.setYValue(savings);
                }
            }
        }

        // Gets the series with the interest applied and updates the data
        XYChart.Series<Number, Number> savingsWithInterestData = lineChart.getData().get(1);
        for (XYChart.Data<Number, Number> data : savingsWithInterestData.getData()) {
            for (int year = 0; year <= 30; year++) {
                if (data.getXValue().equals(year)) {
                    double savings = calculateSavingsWithInterest(year);
                    data.setYValue(savings);
                }
            }
        }

    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}