package Controllers;

import Users.Librarian;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddLibrarianController {

    @FXML public Button addButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;

    @FXML public void add(){
        Librarian librarian = new Librarian(
                0,
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                "Users.Librarian",
                loginTextField.getText(),
                passwordPasswordField.getText()
        );
        LoginController.admin.addLibrarian(librarian);

        Stage stageToBeClosed = (Stage) addButton.getScene().getWindow();
        stageToBeClosed.close();
    }

}
