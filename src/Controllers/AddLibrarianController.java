package Controllers;

import Users.Librarian;
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

        try {
            SuccessErrorController.message = "Librarian is Added!";
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
