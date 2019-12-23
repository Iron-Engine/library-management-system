package Book;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

    private SimpleIntegerProperty isbn;
    private SimpleIntegerProperty borrowerId;
    private SimpleStringProperty title;
    private SimpleStringProperty subject;
    private SimpleStringProperty author;
    private SimpleStringProperty publishDate;
    private SimpleBooleanProperty status;

    // Books.Book default constructor
    public Book(){
        setIsbn(0);
        setTitle("");
        setSubject("");
        setAuthor("");
        setPublishDate("");
        setBorrowerId(0);
        setStatus(true);
    }

    // Books.Book constructor
    public Book(int isbn, String title, String author, String publishDate, String subject, int borrowerId, boolean status){
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPublishDate(publishDate);
        setSubject(subject);
        setBorrowerId(borrowerId);
        setStatus(status);
    }

    // setters
    public void setIsbn(int isbn){ this.isbn = new SimpleIntegerProperty(isbn); }
    private void setTitle(String title){
        this.title = new SimpleStringProperty(title);
    }
    private void setAuthor(String author){
        this.author = new SimpleStringProperty(author);
    }
    private void setPublishDate(String publishDate){
        this.publishDate = new SimpleStringProperty(publishDate);
    }
    private void setSubject(String subject){
        this.subject = new SimpleStringProperty(subject);
    }
    public void setBorrowerId(int borrowerId) { this.borrowerId = new SimpleIntegerProperty(borrowerId); }
    private void setStatus(boolean status){
        this.status = new SimpleBooleanProperty();
    }

    //getters
    public int getIsbn(){
        return this.isbn.get();
    }
    public String getTitle(){
        return this.title.get();
    }
    public String getAuthor(){ return this.author.get(); }
    public String getPublishDate(){ return this.publishDate.get(); }
    public String getSubject(){
        return this.subject.get();
    }
    public int getBorrowerId(){
        return this.borrowerId.get();
    }
    public boolean getStatus(){
        return this.status.get();
    }

    // toString methods
    public String toString(){
        return String.format("Book ISBN: %d\nBook Name: %s\nBook Author: %s\nBook Publish Date: %s\nBook Subject: %s\nBorrower Id: %b\nStatus: %b",
                this.getIsbn(), this.getTitle(), this.getAuthor(), this.getPublishDate(), this.getSubject(), this.getBorrowerId(), this.getStatus());
    }
}
