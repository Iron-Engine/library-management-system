package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ViewLibrariansController {

    @FXML
    public Button addButton;
    @FXML
    public Button modifyButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button backButton;
    @FXML
    public TableView librariansTable;

    @FXML
    public void add() {

    }
    @FXML
    public void modify() {

    }
    @FXML
    public void delete() {

    }
    @FXML
    public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }
}
