package sample;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import java.awt.*;

public class GridView {

  private String turn;
  private String[] movesArray;


  public GridView() {
    this.turn = "X";
    this.movesArray = new String[9];
    Arrays.fill(movesArray, "");
  }

  private void changeTurn() {

    turn = (turn.equals("X")) ? "Y" : "X";
  }

  private boolean isWinner() {
    int[][] horizontalArrays = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    int[][] verticalArrays =   {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
    int[][] diagonalArrays =   {{0, 4, 8}, {2, 4, 6}};
    boolean horizontal = Arrays.stream(horizontalArrays).anyMatch((arr) -> {
      return (movesArray[arr[0]].matches("[XY]") && movesArray[arr[0]].equals(movesArray[arr[1]]) && movesArray[arr[0]].equals(movesArray[arr[2]]));
    });

  }

  private Button createGridButton(int index) {
    Button gridButton = new Button("");
    gridButton.setOnAction((event) -> {
      // check squared is not already played
      if (gridButton.getText().isBlank()) {
        gridButton.setText(turn);
        movesArray[index] = turn;
        // if (isWinner()) change view else changeTurn();
        changeTurn();
      }
    });

    return gridButton;
  }

  public Parent getView() {
    GridPane layout = new GridPane();
    Label turnLabel = new Label(turn);
    ArrayList<Button> gridButtons = new ArrayList<>();
    for (int i = 0; i <= 8; i++) {
      Button gridButton = new Button("");
      int index = i;
      gridButton.setOnAction((event) -> {
        // check squared is not already played
        if (gridButton.getText().isBlank()) {
          gridButton.setText(turn);
          movesArray[index] = turn;
          // check winner
          if (isWinner()) {
            turnLabel.setText("Winner is: " + this.turn);
             return;
          }
          changeTurn();
          turnLabel.setText(this.turn);
        }
      });
      gridButtons.add(gridButton);
    }
    layout.add(gridButtons.get(0), 0, 0);
    layout.add(gridButtons.get(1), 1, 0);
    layout.add(gridButtons.get(2), 2, 0);
    layout.add(gridButtons.get(3), 0, 1);
    layout.add(gridButtons.get(4), 1, 1);
    layout.add(gridButtons.get(5), 2, 1);
    layout.add(gridButtons.get(6), 0, 2);
    layout.add(gridButtons.get(7), 1, 2);
    layout.add(gridButtons.get(8), 2, 2);
    layout.add(turnLabel, 0, 3);

    return layout;
  }
}
