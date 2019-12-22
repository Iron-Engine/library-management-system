package Controllers;

import Database.SqlViewUserType;
import Users.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewStudentController implements Initializable {
    @FXML public Button addButton;
    @FXML public Button modifyButton;
    @FXML public Button deleteButton;
    @FXML public Button backButton;
    @FXML public Button blockButton;
    @FXML public TableView<Student> studentTableView;
    @FXML public TableColumn<Student, Integer> idColumn;
    @FXML public TableColumn<Student, String> firstNameColumn;
    @FXML public TableColumn<Student, String> lastNameColumn;
    @FXML public TableColumn<Student, Integer> fineColumn;
    @FXML public TableColumn<Student, String> usernameColumn;
    @FXML public TableColumn<Student, String> passwordColumn;
    @FXML public TableColumn<Student, Boolean> blockedColumn;

    @FXML public void add() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/AddStudent.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Books");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void modify() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ModifyStudent.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Modify Books");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void delete() {

    }

    @FXML public void block() {

    }

    @FXML public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        fineColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("fine"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("password"));
        blockedColumn.setCellValueFactory(new PropertyValueFactory<Student, Boolean>("blocked"));

        studentTableView.setItems(SqlViewUserType.student());
    }
}
