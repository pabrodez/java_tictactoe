package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import java.awt.*;

public class GridView {

  private String turn;
  private String[] movesArray;


  public GridView() {
    resetTurn();
    resetMovesArray();
  }

  private void changeTurn() {
    turn = (turn.equals("X")) ? "Y" : "X";
  }

  private boolean isWinner() {
    int[][] horizontalArrays = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    int[][] verticalArrays =   {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
    int[][] diagonalArrays =   {{0, 4, 8}, {2, 4, 6}};
    int[][][] allArrays = {horizontalArrays, verticalArrays, diagonalArrays};

    boolean anyThree = Arrays.stream(allArrays).anyMatch((arr) -> {
      return Arrays.stream(arr).anyMatch((inds) -> {
        return (movesArray[inds[0]] + movesArray[inds[1]] + movesArray[inds[2]]).matches("XXX|YYY");
      });
    });

    return anyThree;

  }

  private void resetTurn() {
    this.turn = "X";
  }

  private void resetMovesArray() {
    this.movesArray = new String[9];
    Arrays.fill(movesArray, "");
  }

  private boolean isDraw() {
    return (Arrays.stream(movesArray).noneMatch(String::isBlank));
  }

  public Parent getView(Button startButton, BorderPane mainLayout) {
    // reset game variables
    resetTurn();
    resetMovesArray();
    // base grid
    GridPane layout = new GridPane();
    // create turn label
    Label turnLabel = new Label("Turn: " + this.turn);
    turnLabel.setFont(Font.font("Monospaced"));
    // create list of grid buttons
    ArrayList<Button> gridButtons = new ArrayList<>();
    for (int i = 0; i <= 8; i++) {
      Button gridButton = new Button("");
      int index = i;
      gridButton.setOnAction((event) -> {
        // check square is not already played
        if (gridButton.getText().isBlank()) {
          gridButton.setText(turn);
          movesArray[index] = turn;
          // if no winner or draw, keep playing
          if (isWinner()) {
            ResultView.getView(mainLayout, this.turn, startButton);
          } else if (isDraw()) {
            ResultView.getView(mainLayout, "draw", startButton);
          } else {
            changeTurn();
            turnLabel.setText("Turn: " + this.turn);
          }
        }
      });
      gridButton.setFont(Font.font("Monospaced", 40));
      gridButton.setMinHeight(80);
      gridButton.setMinWidth(80);
      gridButtons.add(gridButton);
    }
    layout.add(turnLabel, 0, 0);
    layout.add(gridButtons.get(0), 0, 1);
    layout.add(gridButtons.get(1), 1, 1);
    layout.add(gridButtons.get(2), 2, 1);
    layout.add(gridButtons.get(3), 0, 2);
    layout.add(gridButtons.get(4), 1, 2);
    layout.add(gridButtons.get(5), 2, 2);
    layout.add(gridButtons.get(6), 0, 3);
    layout.add(gridButtons.get(7), 1, 3);
    layout.add(gridButtons.get(8), 2, 3);

    // visual
    layout.setAlignment(Pos.CENTER);
    layout.setHgap(10);
    layout.setVgap(10);
    layout.setPadding(new Insets(10, 10 , 10, 10));

    return layout;
  }
}
