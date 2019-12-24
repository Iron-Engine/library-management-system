package Controllers;

import Users.Librarian;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyLibrarianController implements Initializable {

    @FXML public Button modifyButton;
    @FXML public TextField firstNameTextField;
    @FXML public TextField lastNameTextField;
    @FXML public TextField loginTextField;
    @FXML public PasswordField passwordPasswordField;

    @FXML public void modify(){
        try {
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
            try {
                SuccessErrorController.message = "Librarian is Modified!";
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Everything is Ok");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (NullPointerException e){
            try {
                SuccessErrorController.message = "Wrong Input!";
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Something wrong");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameTextField.setText(ViewLibrariansController.librarian.getFirstName());
        lastNameTextField.setText(ViewLibrariansController.librarian.getLastName());
        loginTextField.setText(ViewLibrariansController.librarian.getUsername());
        passwordPasswordField.setText(ViewLibrariansController.librarian.getPassword());
    }
}
