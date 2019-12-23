package Controllers;

import Book.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ModifyBookController implements Initializable {

    @FXML public Button modifyButton;
    @FXML public TextField ISBNTextField;
    @FXML public TextField subjectTextField;
    @FXML public TextField authorTextField;
    @FXML public TextField titleTextField;
    @FXML public DatePicker publishDateTextField;

    @FXML public void modify(){
        try {
            LocalDate publishDateLocalDate = publishDateTextField.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String publishDateString = publishDateLocalDate.format(formatter);
            ViewBooksController.book.setIsbn(Integer.parseInt(ISBNTextField.getText()));
            Book book = new Book(
                    ViewBooksController.book.getIsbn(),
                    titleTextField.getText(),
                    authorTextField.getText(),
                    publishDateString,
                    subjectTextField.getText(),
                    ViewBooksController.book.getBorrowerId(),
                    ViewBooksController.book.getStatus()

            );
            LoginController.librarian.modifyBook(book);

            Stage stageToBeClosed = (Stage) modifyButton.getScene().getWindow();
            stageToBeClosed.close();
            try {
                SuccessErrorController.message = "Book is Modified!";
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Everything is Ok");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (NullPointerException e){
            try {
                SuccessErrorController.message = "Wrong Input!";
                Parent parent = FXMLLoader.load(getClass().getResource("../GUI/SuccessError.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Something wrong");
                stage.setScene(new Scene(parent));
                stage.show();

            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ISBNTextField.setText(Integer.toString(ViewBooksController.book.getIsbn()));
        subjectTextField.setText(ViewBooksController.book.getSubject());
        authorTextField.setText(ViewBooksController.book.getAuthor());
        titleTextField.setText(ViewBooksController.book.getTitle());
    }
}