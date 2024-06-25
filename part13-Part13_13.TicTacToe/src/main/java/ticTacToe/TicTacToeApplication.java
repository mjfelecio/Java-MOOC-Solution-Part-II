package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    BorderPane layout = new BorderPane();
    GridPane gameBoard = new GridPane();
    boolean playerXTurn = true;
    Label turnInformation = new Label("Turn: X");
    Button[][] buttonAddress = new Button[3][3];

    @Override
    public void start(Stage stage) {

        turnInformation.setFont(new Font("Inter Font", 40));

        layout.setTop(turnInformation);
        layout.setPadding(new Insets(20));
        layout.setCenter(createGameBoard(gameBoard));

        Scene gameScene = new Scene(layout, 300, 350);

        stage.setScene(gameScene);
        stage.setTitle("TicTacToe");
        stage.show();
    }


    public GridPane createGameBoard(GridPane gameBoard) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                // creating and setting up the buttons
                Button button = new Button(" ");
                buttonAddress[row][col] = button;
                button.setFont(Font.font("Monospaced", 40));

                button.setOnAction(event -> {
                    button.setText(setPlayerTurn());
                    button.setDisable(true);
                    checkWinner();

                    if (button.getText().equals("X")) {
                        button.setStyle("-fx-background-color: Red; ");

                    } else if (button.getText().equals("O")) {
                        button.setStyle("-fx-background-color: Blue; ");
                    }
                });

                // putting the buttons to the GridPane and styling it
                gameBoard.add(button, col, row);
                gameBoard.setAlignment(Pos.CENTER);
                gameBoard.setHgap(10);
                gameBoard.setVgap(10);
                gameBoard.setPadding(new Insets(10));
            }
        }
        return gameBoard;
    }

    private String setPlayerTurn() {
        if (playerXTurn) {
            turnInformation.setText("Turn: O");
            playerXTurn = false;

            return "X";

        } else {
            turnInformation.setText("Turn: X");
            playerXTurn = true;

            return "O";
        }
    }

    private void checkWinner() {
        // checks the horizontal lines for X
        if (buttonAddress[0][0].getText().equals("X")
            && buttonAddress[0][1].getText().equals("X")
            && buttonAddress[0][2].getText().equals("X")) {
            xWins();
        }

        if (buttonAddress[1][0].getText().equals("X")
                && buttonAddress[1][1].getText().equals("X")
                && buttonAddress[1][2].getText().equals("X")) {
            xWins();
        }

        if (buttonAddress[2][0].getText().equals("X")
                && buttonAddress[2][1].getText().equals("X")
                && buttonAddress[2][2].getText().equals("X")) {
            xWins();
        }

        // checks the vertical line for X
        if (buttonAddress[0][0].getText().equals("X")
                && buttonAddress[1][0].getText().equals("X")
                && buttonAddress[2][0].getText().equals("X")) {
            xWins();
        }

        if (buttonAddress[0][1].getText().equals("X")
                && buttonAddress[1][1].getText().equals("X")
                && buttonAddress[2][1].getText().equals("X")) {
            xWins();
        }

        if (buttonAddress[0][2].getText().equals("X")
                && buttonAddress[1][2].getText().equals("X")
                && buttonAddress[2][2].getText().equals("X")) {
            xWins();
        }

        //checks the diagonal lines for X
        if (buttonAddress[0][0].getText().equals("X")
                && buttonAddress[1][1].getText().equals("X")
                && buttonAddress[2][2].getText().equals("X")) {
            xWins();
        }

        if (buttonAddress[0][2].getText().equals("X")
                && buttonAddress[1][1].getText().equals("X")
                && buttonAddress[2][0].getText().equals("X")) {
            xWins();
        }

        // checks the horizontal lines for O
        if (buttonAddress[0][0].getText().equals("O")
                && buttonAddress[0][1].getText().equals("O")
                && buttonAddress[0][2].getText().equals("O")) {
            oWins();
        }

        if (buttonAddress[1][0].getText().equals("O")
                && buttonAddress[1][1].getText().equals("O")
                && buttonAddress[1][2].getText().equals("O")) {
            oWins();
        }

        if (buttonAddress[2][0].getText().equals("O")
                && buttonAddress[2][1].getText().equals("O")
                && buttonAddress[2][2].getText().equals("O")) {
            oWins();
        }

        // checks the vertical line for O
        if (buttonAddress[0][0].getText().equals("O")
                && buttonAddress[1][0].getText().equals("O")
                && buttonAddress[2][0].getText().equals("O")) {
            oWins();
        }

        if (buttonAddress[0][1].getText().equals("O")
                && buttonAddress[1][1].getText().equals("O")
                && buttonAddress[2][1].getText().equals("O")) {
            oWins();
        }

        if (buttonAddress[0][2].getText().equals("O")
                && buttonAddress[1][2].getText().equals("O")
                && buttonAddress[2][2].getText().equals("O")) {
            oWins();
        }

        //checks the diagonal lines for O
        if (buttonAddress[0][0].getText().equals("O")
                && buttonAddress[1][1].getText().equals("O")
                && buttonAddress[2][2].getText().equals("O")) {
            oWins();
        }

        if (buttonAddress[0][2].getText().equals("O")
                && buttonAddress[1][1].getText().equals("O")
                && buttonAddress[2][0].getText().equals("O")) {
            oWins();
        }
    }

    private void xWins() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonAddress[row][col].setDisable(true);
            }
        }
        turnInformation.setText("The end!");
    }

    private void oWins() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonAddress[row][col].setDisable(true);
            }
        }
        turnInformation.setText("The end!");
    }

}
