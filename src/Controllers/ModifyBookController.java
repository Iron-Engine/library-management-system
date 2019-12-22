package Controllers;

import Book.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        LocalDate publishDateLocalDate = publishDateTextField.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String publishDateString = publishDateLocalDate.format(formatter);

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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ISBNTextField.setText(Integer.toString(ViewBooksController.book.getIsbn()));
        subjectTextField.setText(ViewBooksController.book.getSubject());
        authorTextField.setText(ViewBooksController.book.getAuthor());
        titleTextField.setText(ViewBooksController.book.getTitle());
    }
}