package sample;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StartButton {

  public StartButton() {}

  public static Button getStartButton(BorderPane layout) {
    Button startButton = new Button("New Game");
    GridView gridView = new GridView();
    startButton.setOnAction((ev) -> {
      layout.setCenter(gridView.getView(StartButton.getStartButton(layout), layout));
    });

    return startButton;
  }
}
