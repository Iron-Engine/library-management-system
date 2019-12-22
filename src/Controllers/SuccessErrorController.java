package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SuccessErrorController implements Initializable {

    public static String message;
    @FXML
    public Label ReportLabel;
    @FXML
    public Button okButton;

    @FXML public void ok(){
        Stage stageToBeClosed = (Stage) okButton.getScene().getWindow();
        stageToBeClosed.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ReportLabel.setText(message);
    }
}
