package Book;

import java.time.LocalDate;

public class Book {

    private int isbn;
    private int borrowerId;
    private String title;
    private String subject;
    private String author;
    private LocalDate publishDate;
    private boolean status;

    // Books.Book default constructor
    public Book(){
        setIsbn(0);
        setTitle("");
        setSubject("");
        setAuthor("");
        setPublishDate(null);
        setBorrowerId(0);
        setStatus(true);
    }

    // Books.Book constructor
    public Book(int isbn, String title, String author, LocalDate publishDate, String subject, int borrowerId, boolean status){
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setPublishDate(publishDate);
        setSubject(subject);
        setBorrowerId(borrowerId);
        setStatus(status);
    }

    // setters
    private void setIsbn(int isbn){ this.isbn = isbn; }
    private void setTitle(String title){
        this.title = title;
    }
    private void setAuthor(String author){
        this.author = author;
    }
    private void setPublishDate(LocalDate publishDate){
        this.publishDate = publishDate;
    }
    private void setSubject(String subject){
        this.subject = subject;
    }
    private void setBorrowerId(int borrowerId) { this.borrowerId = borrowerId; }
    private void setStatus(boolean status){
        this.status = status;
    }

    //getters
    public int getIsbn(){
        return this.isbn;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public LocalDate getPublishDate(){ return this.publishDate; }
    public String getSubject(){
        return this.subject;
    }
    public int getBorrowerId(){
        return this.borrowerId;
    }
    public boolean getStatus(){
        return this.status;
    }

    // toString methods
    public String toString(){
        return String.format("Book ISBN: %d\nBook Name: %s\nBook Author: %s\nBook Publish Date: %s\nBook Subject: %s\nBorrower Id: %b\nStatus: %b",
                this.getIsbn(), this.getTitle(), this.getAuthor(), this.getPublishDate(), this.getSubject(), this.getBorrowerId(), this.getStatus());
    }
}
