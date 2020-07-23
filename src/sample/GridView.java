package sample;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.stream.Stream;

import java.awt.*;

public class GridView {

  private String turn;
  private String[] movesArray = new String[9];

  public GridView() {
    this.turn = "X";
  }

  private void changeTurn() {
    turn = (turn.equals("X")) ? "Y" : "X";
  }

  private boolean isWinner() {
    boolean horizontal = (movesArray[0].equals(movesArray[1]) && movesArray[1].equals(movesArray[2])) ||
            (movesArray[3].equals(movesArray[4]) && movesArray[4].equals(movesArray[5])) ||
            (movesArray[6].equals(movesArray[7]) && movesArray[7].equals(movesArray[8]));
    boolean vertical = (movesArray[0].equals(movesArray[3]) && movesArray[3].equals(movesArray[6])) ||
            (movesArray[1].equals(movesArray[4]) && movesArray[1].equals(movesArray[7])) ||
            (movesArray[2].equals(movesArray[5]) && movesArray[2].equals(movesArray[8]));
    boolean diagonal = (movesArray[0].equals(movesArray[4]) && movesArray[4].equals(movesArray[8])) ||
            (movesArray[2].equals(movesArray[4]) && movesArray[4].equals(movesArray[6]));

    return horizontal || vertical || diagonal;
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
    layout.add(createGridButton(0), 0, 0);
    layout.add(createGridButton(1), 1, 0);
    layout.add(createGridButton(2), 2, 0);
    layout.add(createGridButton(3), 0, 1);
    layout.add(createGridButton(4), 1, 1);
    layout.add(createGridButton(5), 2, 1);
    layout.add(createGridButton(6), 0, 2);
    layout.add(createGridButton(7), 1, 2);
    layout.add(createGridButton(8), 2, 2);
    layout.add(turnLabel, 0, 3);

    return layout;
  }
}
