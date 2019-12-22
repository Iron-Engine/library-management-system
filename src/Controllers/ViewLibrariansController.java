package Controllers;

import Book.Book;
import Database.SqlViewAllBook;
import Database.SqlViewUserType;
import Users.Librarian;
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

public class ViewLibrariansController implements Initializable {

    @FXML
    public Button addButton;
    @FXML
    public Button modifyButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button backButton;

    @FXML public TableView<Librarian> librariansTableView;

    @FXML
    public void add() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/AddLibrarian.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Add Librarian");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void modify() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ModifyLibrarian.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Modify Librarian");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void delete() {

    }
    @FXML
    public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        librariansTableView.setItems(SqlViewUserType.librarian());
    }
}
