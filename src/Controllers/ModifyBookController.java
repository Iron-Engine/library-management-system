package Controllers;

import Book.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class ModifyBookController {
    @FXML
    public Button modifyButton;
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
    public void modify(){
        Book book = new Book(
                Integer.parseInt(ISBNTextField.getText()),
                titleTextField.getText(),
                authorTextField.getText(),
                publishDateTextField.getValue(),
                subjectTextField.getText(),
                0,
                true
        );
        LoginController.librarian.modifyBook(book);

        Stage stageToBeClosed = (Stage) modifyButton.getScene().getWindow();
        stageToBeClosed.close();
    }

}