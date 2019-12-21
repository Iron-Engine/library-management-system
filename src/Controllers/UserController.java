package Controllers;

import Users.User;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    public Button booksButton;
    @FXML
    public Button studentsButton;
    @FXML
    public Button librariansButton;
    @FXML
    public Button logoutButton;
    @FXML
    public Label firstNameLabel;
    @FXML
    public Label lastNameLabel;
    @FXML
    public Label fineLabel;
    @FXML
    public Label blockedLabel;
    @FXML
    public Label headerLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userType = LoginController.user.getType().getClass().getName();

        firstNameLabel.setText(LoginController.user.getFirstName());
        lastNameLabel.setText(LoginController.user.getLastName());

        if(userType.equals("User.Admin")){
            headerLabel.setText("Admin Page");
            fineLabel.setVisible(false);
            blockedLabel.setVisible(false);
        }
        else if(userType.equals("User.Librarian")){
            headerLabel.setText("Librarian Page");
            librariansButton.setVisible(false);
            fineLabel.setVisible(false);
            blockedLabel.setVisible(false);
        }
        else if(userType.equals("User.Student")){
            headerLabel.setText("Student Page");
            fineLabel.setText(Integer.toString(LoginController.student.getFine()));
            blockedLabel.setText(Boolean.toString(LoginController.student.getBlocked()));
            librariansButton.setVisible(false);
            studentsButton.setVisible(false);
        }
    }

    @FXML
    public void viewBooks() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewBooks.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Books");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void viewLibrarians() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewLibrarians.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Librarians");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void viewStudents() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewStudents.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Students");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}