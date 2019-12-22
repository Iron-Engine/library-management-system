package Controllers;

import Book.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class AddBookController {
    @FXML
    public Button addButton;
    @FXML
    public TextField ISBNTextField;
    @FXML
    public TextField subjectTextField;
    @FXML
    public TextField authorTextField;
    @FXML
    public TextField titleTextField;
    @FXML
    public DatePicker publishDateTextField;

    @FXML
    public void add() {
        Book book = new Book(
                Integer.parseInt(ISBNTextField.getText()),
                titleTextField.getText(),
                authorTextField.getText(),
                publishDateTextField.getValue(),
                subjectTextField.getText(),
                0,
                true
        );
        LoginController.librarian.addBook(book);

        Stage stageToBeClosed = (Stage) addButton.getScene().getWindow();
        stageToBeClosed.close();
    }
}
