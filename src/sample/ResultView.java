package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ResultView {

  public ResultView() {}

  public static void getView(BorderPane mainLayout, String result, Button startButton) {

    VBox box = new VBox();
    Label resultLabel = new Label();
    String resultText = switch (result) {
      case "X" -> "Winner is X";
      case "Y" -> "Winner is Y";
      default  -> "It's a draw";
    };
    resultLabel.setText(resultText);
    box.getChildren().add(resultLabel);
    box.getChildren().add(startButton);
    box.setAlignment(Pos.CENTER);
    box.setSpacing(10);
    mainLayout.getChildren().clear();
    mainLayout.setCenter(box);
  }
}
