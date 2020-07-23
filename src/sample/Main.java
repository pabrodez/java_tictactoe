package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent gridView = new GridView().getView();
        Scene mainLayout = new Scene(gridView);
        primaryStage.setScene(mainLayout);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(Main.class);
    }
}
