package App;
import Database.SqlModifyUser;
import Users.Student;
import Users.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;

public class Main extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Scene scene1, scene2;


    public static void main(String[] args) {
//        JFrame frame = new JFrame("App");
//        mainLayout loginLayout = new mainLayout();
//        loginLayout.setVisible(true);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Title here");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Label label1 = new Label("Welcome to scene 1");
        Button button = new Button("Go to scene 2");
        button.setOnAction(e -> window.setScene(scene2));

        Label label2 = new Label("Welcome to scene 2");
        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> LoginWindow.display());
//        button2.setOnAction(e -> AlertBox.display("Alert Box", "Some Error occurred!"));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1, 200, 200);

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        layout2.setAlignment(Pos.CENTER);
        scene2 = new Scene(layout2, 200, 200);

        window.setScene(scene1);
        window.show();






        //        primaryStage.setTitle("Title of Window");
//        button = new Button();
//        button.setText("Click Me");
//        button.setOnAction(e -> System.out.println("Button was clicked"));
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//        Scene scene = new Scene(layout, 300, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();

//        Parent root = FXMLLoader.load(getClass().getResource("mainLayout"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }


//    public static void main(String[] args) {
//        loginWindow window = new loginWindow();
//        window.setVisible(true);
//        Librarian obj = new Librarian(1, "Bunyod", "Khakimov", "login", "password");
//        obj.acc.Login("login", "password");
//        System.out.println(obj.getClass().getName());
//        SqlModifyUser objSQL = new SqlModifyUser();
//        objSQL.main(obj);
//    }

    public void closeProgram(){
        boolean answer = ConfirmBox.display("Confirm Box", "Sure you want to exit?");
        if(answer)
            window.close();
    }

}
