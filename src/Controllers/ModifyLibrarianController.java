package Controllers;

import Users.Librarian;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyLibrarianController {

    @FXML public Button modifyButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;

    @FXML public void modify(){
        Librarian librarian = new Librarian(
                0,
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                "Users.Librarian",
                loginTextField.getText(),
                passwordPasswordField.getText()
        );
        LoginController.admin.modifyLibrarian(librarian);

        Stage stageToBeClosed = (Stage) modifyButton.getScene().getWindow();
        stageToBeClosed.close();
    }
}
