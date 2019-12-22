package Controllers;

import Book.Book;
import Database.SqlViewBorrowedBooks;
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

public class ViewMyBooksController implements Initializable {

    @FXML public Button backButton;
    @FXML public TableView<Book> booksTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booksTable.setItems(SqlViewBorrowedBooks.main(LoginController.student.getId()));
    }

    @FXML public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }

}

