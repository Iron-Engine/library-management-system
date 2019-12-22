package Controllers;

import Users.Librarian;
import Users.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyStudentController {

    @FXML public Button modifyButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;
    @FXML public TextField fineTextField;
    @FXML public TextField blockedTextField;

    @FXML public void modify(){
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
        new Librarian().modifyStudent(student);

        Stage stageToBeClosed = (Stage) modifyButton.getScene().getWindow();
        stageToBeClosed.close();
    }

}
