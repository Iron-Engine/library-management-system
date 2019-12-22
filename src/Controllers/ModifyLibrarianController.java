package Controllers;

import Users.Librarian;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyLibrarianController implements Initializable {

    @FXML public Button modifyButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;

    @FXML public void modify(){
        Librarian librarian = new Librarian(
                ViewLibrariansController.librarian.getId(),
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                ViewStudentController.student.getType(),
                loginTextField.getText(),
                passwordPasswordField.getText()
        );
        LoginController.admin.modifyLibrarian(librarian);

        Stage stageToBeClosed = (Stage) modifyButton.getScene().getWindow();
        stageToBeClosed.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameTextField.setText(ViewLibrariansController.librarian.getFirstName());
        lastNameTextField.setText(ViewLibrariansController.librarian.getLastName());
        loginTextField.setText(ViewLibrariansController.librarian.getUsername());
        passwordPasswordField.setText(ViewLibrariansController.librarian.getPassword());
    }
}
