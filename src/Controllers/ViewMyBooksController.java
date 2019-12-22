package Controllers;

import Book.Book;
import Database.SqlViewBorrowedBooks;
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

public class ViewMyBooksController implements Initializable {

    @FXML public Button backButton;
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
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbn"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("subject"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publishDateColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publishDate"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        borrowerIDColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("borrowerId"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("status"));

        booksTableView.setItems(SqlViewBorrowedBooks.main(LoginController.student.getId()));
    }

    @FXML public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }

}

