package App;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginWindow {
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login Window");
        window.setWidth(300);
        window.setHeight(300);

        Label labelUsername = new Label();
        labelUsername.setText("Username");

        Label labelPassword = new Label();
        labelPassword.setText("Password");

        TextArea textAreaUsername = new TextArea();
        String username = textAreaUsername.getText();

        TextArea textAreaPassword = new TextArea();
        String password = textAreaUsername.getText();

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(labelUsername, textAreaUsername);
        layout.getChildren().addAll(labelPassword, textAreaPassword, loginButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
