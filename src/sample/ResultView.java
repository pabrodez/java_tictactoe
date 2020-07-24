package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ResultView {

  public ResultView() {}

  public static Parent getView(String result) {

    StackPane layout = new StackPane();
    Label resultLabel = new Label();
    String resultText = switch (result) {
      case "X" -> "Winner is X";
      case "Y" -> "Winner is Y";
      default  -> "It's a draw";
    };
    resultLabel.setText(resultText);
    layout.getChildren().add(resultLabel);

    return layout;
  }
}
