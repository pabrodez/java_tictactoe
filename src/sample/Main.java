package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // create grid view
        GridView gridView = new GridView();
        // main layout
        BorderPane layout = new BorderPane();
        // top menu
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(10, 10, 10, 10));
        // create and add new game button
        Button startButton = new Button("New Game");
        startButton.setOnAction((ev) -> layout.setCenter(gridView.getView()));
        topMenu.getChildren().add(startButton);
        layout.setTop(topMenu);
        // TODO: add buttons to views here, not in the views themselves

        // create scene
        Scene mainScene = new Scene(layout, 400 , 400);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("java_ticktacktoe");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(Main.class);
    }
}
