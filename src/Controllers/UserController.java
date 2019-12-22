package Controllers;

import Users.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML public Button booksButton;
    @FXML public Button studentsButton;
    @FXML public Button librariansButton;
    @FXML public Button logoutButton;
    @FXML public Label firstNameLabel;
    @FXML public Label lastNameLabel;
    @FXML public Label fineLabel;
    @FXML public Label blockedLabel;
    @FXML public Label headerLabel;
    @FXML public Button myBooksButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userType = LoginController.user.getClass().getName();

        firstNameLabel.setText(LoginController.user.getFirstName());
        lastNameLabel.setText(LoginController.user.getLastName());

        switch (userType) {
            case "Users.Admin":
                headerLabel.setText("Admin Page");
                fineLabel.setVisible(false);
                blockedLabel.setVisible(false);
                myBooksButton.setVisible(false);
                break;
            case "Users.Librarian":
                headerLabel.setText("Librarian Page");
                librariansButton.setVisible(false);
                fineLabel.setVisible(false);
                blockedLabel.setVisible(false);
                myBooksButton.setVisible(false);
                break;
            case "Users.Student":
                headerLabel.setText("Student Page");
                fineLabel.setText(Integer.toString(LoginController.student.getFine()));
                if (Boolean.toString(LoginController.student.getBlocked()).equals("false"))
                    blockedLabel.setText("NO");
                else
                    blockedLabel.setText("YES");
                librariansButton.setVisible(false);
                studentsButton.setVisible(false);
                break;
        }
    }

    @FXML public void viewBooks() {
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

    @FXML public void viewLibrarians() {
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

    @FXML public void viewStudents() {
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

    @FXML public void viewMyBooks() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewMyBooks.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Books");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void logout() throws IOException {
        Stage stageToBeClosed = (Stage) logoutButton.getScene().getWindow();
        stageToBeClosed.close();

        Parent parent = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(parent, 338, 400));
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.show();
    }

}