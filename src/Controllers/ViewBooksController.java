package Controllers;

import com.mysql.cj.xdevapi.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewBooksController {

    @FXML
    public Button addButton;
    @FXML
    public Button modifyButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button backButton;
    @FXML
    public TableView booksTable;

    @FXML
    public void add() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/AddBook.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Add Book");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
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

