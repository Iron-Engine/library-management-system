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
    public TableView bookTable;

    @FXML
    public void add() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewBooks.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Books");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void modify() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewLibrarians.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Librarians");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void delete() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewStudents.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Students");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

