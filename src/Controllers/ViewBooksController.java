package Controllers;

import Book.Book;
import Database.SqlDeleteUser;
import Database.SqlGetBook;
import Database.SqlViewAllBook;
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

public class ViewBooksController implements Initializable {

    public static Book book = new Book();

    @FXML public TextField isbnTextField;
    @FXML public Button addButton;
    @FXML public Button modifyButton;
    @FXML public Button deleteButton;
    @FXML public Button backButton;
    @FXML public Button reserveButton;
    @FXML public TableView<Book> booksTableView;
    @FXML public TableColumn<Book, Integer> ISBNColumn;
    @FXML public TableColumn<Book, String> subjectColumn;
    @FXML public TableColumn<Book, String> authorColumn;
    @FXML public TableColumn<Book, String> publishDateColumn;
    @FXML public TableColumn<Book, String> titleColumn;
    @FXML public TableColumn<Book, Integer> borrowerIDColumn;
    @FXML public TableColumn<Book, Boolean> availableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String userType = LoginController.user.getClass().getName();
        if (userType.equals("Users.Student")) {
            addButton.setVisible(false);
            modifyButton.setVisible(false);
            deleteButton.setVisible(false);
        } else
            reserveButton.setVisible(false);

        ISBNColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbn"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("subject"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publishDateColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publishDate"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        borrowerIDColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("borrowerId"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("status"));

        booksTableView.setItems(SqlViewAllBook.main());
    }

    @FXML public void add() {
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

    @FXML public void modify() {
        try {
            try {
                book = SqlGetBook.main(Integer.parseInt(isbnTextField.getText()));

                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ModifyBook.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Modify Book");
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (NumberFormatException e) {
                try {
                    SuccessErrorController.message = "No Book (ISBN) found!";
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
            new SqlDeleteUser().main(Integer.parseInt(isbnTextField.getText()));
        }
        catch (NumberFormatException e) {
            try {
                SuccessErrorController.message = "No Book (ISBN) found!";
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

    @FXML public void reserve(){}

}

