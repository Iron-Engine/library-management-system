package Controllers;

import Database.SqlBlockUser;
import Database.SqlDeleteUser;
import Database.SqlGetUser;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewStudentController implements Initializable {

    public static Student student= new Student();

    @FXML public TextField idTextField;
    @FXML public Button addButton;
    @FXML public Button modifyButton;
    @FXML public Button deleteButton;
    @FXML public Button backButton;
    @FXML public Button blockButton;
    @FXML public Button refreshButton;
    @FXML public TableView<Student> studentTableView;
    @FXML public TableColumn<Student, Integer> idColumn;
    @FXML public TableColumn<Student, String> firstNameColumn;
    @FXML public TableColumn<Student, String> lastNameColumn;
    @FXML public TableColumn<Student, Integer> fineColumn;
    @FXML public TableColumn<Student, String> usernameColumn;
    @FXML public TableColumn<Student, String> passwordColumn;
    @FXML public TableColumn<Student, Boolean> blockedColumn;

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
            try {
                student = SqlGetUser.returnStudent(Integer.parseInt(idTextField.getText()));
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ModifyStudent.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Modify Books");
                stage.setScene(new Scene(parent));
                stage.show();
            }
            catch (NumberFormatException e) {
                try {
                    SuccessErrorController.message = "No Student (ID) found!";
                    Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setResizable(false);
                    stage.setTitle("Something Wrong");
                    stage.setScene(new Scene(parent));
                    stage.show();

                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void delete() {
        try {
            SqlDeleteUser.main(Integer.parseInt(idTextField.getText()));
            try {
                SuccessErrorController.message = "Student is Deleted!";
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
        catch (NumberFormatException e) {
            try {
                SuccessErrorController.message = "No Student (ID) found!";
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Something Wrong");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @FXML public void block() {
        try {
            SqlBlockUser.main(Integer.parseInt(idTextField.getText()));
            try {
                SuccessErrorController.message = "Student is Blocked!";
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
        catch (NumberFormatException e) {
            try {
                SuccessErrorController.message = "No Student (ID) found!";
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Something Wrong");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @FXML public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }

    @FXML public void refresh(){
        Stage stageToBeClosed = (Stage) refreshButton.getScene().getWindow();
        stageToBeClosed.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ViewStudents.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Books");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
