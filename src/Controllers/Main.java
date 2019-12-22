package Controllers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));

        primaryStage.setScene(new Scene(root, 338, 400));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}
