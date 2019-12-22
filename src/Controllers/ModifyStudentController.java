package Controllers;

import Users.Librarian;
import Users.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyStudentController implements Initializable {

    @FXML public Button modifyButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;
    @FXML public TextField fineTextField;
    @FXML public TextField blockedTextField;

    @FXML public void modify(){
        Student student = new Student(
                ViewStudentController.student.getId(),
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                ViewStudentController.student.getType(),
                Integer.parseInt(fineTextField.getText()),
                Boolean.parseBoolean(blockedTextField.getText()),
                loginTextField.getText(),
                passwordPasswordField.getText()
        );
        new Librarian().modifyStudent(student);

        Stage stageToBeClosed = (Stage) modifyButton.getScene().getWindow();
        stageToBeClosed.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameTextField.setText(ViewStudentController.student.getFirstName());
        lastNameTextField.setText(ViewStudentController.student.getLastName());
        loginTextField.setText(ViewStudentController.student.getUsername());
        passwordPasswordField.setText(ViewStudentController.student.getPassword());
        fineTextField.setText(Integer.toString(ViewStudentController.student.getFine()));
        blockedTextField.setText(Boolean.toString(ViewStudentController.student.getBlocked()));
    }
}
