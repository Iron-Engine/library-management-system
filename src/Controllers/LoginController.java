package Controllers;

import Database.SqlGetUser;
import Users.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class LoginController {

    public static User user = new User();
    public static Librarian librarian = new Librarian();
    public static Student student = new Student();
    public static Admin admin = new Admin();

    @FXML
    public Button loginButton;
    @FXML
    public TextField loginTextField;
    @FXML
    public PasswordField passwordTextField;


    @FXML
    public void login() {
        int id = user.account.login(loginTextField.getText(), passwordTextField.getText());

        user = SqlGetUser.main(id);
        assert user != null;
        String userType = user.getClass().getName();

        Stage stageToBeClosed = (Stage) loginButton.getScene().getWindow();
        stageToBeClosed.close();

        switch (userType) {
            case "Users.Admin":
                try {
                    admin = SqlGetUser.returnAdmin(id);
                    Parent parent = FXMLLoader.load(getClass().getResource("../GUI/User.fxml"));
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setResizable(false);
                    stage.setTitle("Admin Page");
                    stage.setScene(new Scene(parent));
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Users.Librarian":
                try {
                    librarian = SqlGetUser.returnLibrarian(id);
                    Parent parent = FXMLLoader.load(getClass().getResource("../GUI/User.fxml"));
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setResizable(false);

                    stage.setTitle("Librarian Page");
                    stage.setScene(new Scene(parent));
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Users.Student":
                try {
                    student = SqlGetUser.returnStudent(id);
                    Parent parent = FXMLLoader.load(getClass().getResource("../GUI/User.fxml"));
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setResizable(false);
                    stage.setTitle("Student Page");
                    stage.setScene(new Scene(parent));
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}

