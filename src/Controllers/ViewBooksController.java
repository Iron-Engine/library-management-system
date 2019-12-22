package Controllers;

import Book.Book;
import Database.SqlViewAllBook;
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
import java.util.Date;
import java.util.ResourceBundle;

public class ViewBooksController implements Initializable {

    @FXML public Button addButton;
    @FXML public Button modifyButton;
    @FXML public Button deleteButton;
    @FXML public Button backButton;
    @FXML public Button reserveButton;
    @FXML public TableView<Book> booksTableView;
    @FXML public TableColumn<Book, Integer> ISBNColumn;
    @FXML public TableColumn<Book, String> subjectColumn;
    @FXML public TableColumn<Book, String> authorColumn;
    @FXML public TableColumn<Book, Date> publishDateColumn;
    @FXML public TableColumn<Book, String> titleColumn;
    @FXML public TableColumn<Book, Integer> borrowerIDColumn;
    @FXML public TableColumn<Book, Boolean> availableColumn;

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
            Parent parent = FXMLLoader.load(getClass().getResource("../GUI/ModifyBook.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Modify Book");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void delete() {

    }

    @FXML public void back() {
        Stage stageToBeClosed = (Stage) backButton.getScene().getWindow();
        stageToBeClosed.close();
    }
    @FXML public void reserve(){}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // baktiwka
        String userType = LoginController.user.getClass().getName();
        if (userType.equals("Users.Student")) {
            addButton.setVisible(false);
            modifyButton.setVisible(false);
            deleteButton.setVisible(false);
        } else
            reserveButton.setVisible(false);

        // dly tablici
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("1223"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("Math"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("James Gun"));
        publishDateColumn.setCellValueFactory(new PropertyValueFactory<Book, Date>("22/12/1999"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("Math for War"));
        borrowerIDColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("1"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("true"));

        booksTableView.setItems(SqlViewAllBook.main());
    }
}

