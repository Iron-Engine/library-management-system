package Controllers;

import Users.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    }

}
