package Controllers;

import Users.Student;
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

public class AddStudentController {

    @FXML public Button addButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;

    @FXML public void add(){
        Student student = new Student(
                0,
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                "Users.Librarian",
                0,
                false,
                loginTextField.getText(),
                passwordPasswordField.getText()
        );
        LoginController.librarian.addStudent(student);

        Stage stageToBeClosed = (Stage) addButton.getScene().getWindow();
        stageToBeClosed.close();

        try {
            SuccessErrorController.message = "Student is Added!";
            Parent parent2 = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
            Stage stage2 = new Stage(StageStyle.DECORATED);
            stage2.setResizable(false);
            stage2.setTitle("Everything is Ok");
            stage2.setScene(new Scene(parent2));
            stage2.show();

        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

}
