package Controllers;
import Database.SqlGetUser;
import Users.*;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    public Button button;
    @FXML
    public Button librariansButton;
    @FXML
    public TextField LoginField;
    @FXML
    public PasswordField PasswordField;


    @FXML
    public void LoginButtonHandler(ActionEvent event) {
        User user = new User();
        int id = user.account.login(LoginField.getText(), PasswordField.getText());

        user = SqlGetUser.main(id);
        String userType = user.getClass().getName();

        if (userType.equals("Users.Admin")) {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/User.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Admin Page");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (userType.equals("Users.Librarian")) {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/User.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);

                stage.setTitle("Librarian Page");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (userType.equals("Users.Student")) {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/User.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Student Page");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

