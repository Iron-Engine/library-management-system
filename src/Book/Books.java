package Book;

import java.util.Scanner;

public class Books {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int quantity;
    private String status;

    // Books default constructor
    Books(){
        bookId = 0;
        bookName = "";
        bookAuthor = "";
        status = "";
    }

    // Books constructor
    private Books(int bookId, String bookName, String bookAuthor, String status){
        setBookId(bookId);
        setBookName(bookName);
        setBookAuthor(bookAuthor);
        setQuantity(quantity);
        setStatus(status);
    }

    // setters
    private void setBookId(int bookId){
        this.bookId = bookId;
    }
    private void setBookName(String bookName){
        this.bookName = bookName;
    }
    private void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }
    private void setQuantity(int quantity){
        this.quantity = quantity;
    }
    private void setStatus(String status){
        this.status = status;
    }

    //getters
    private int getBookId(){
        return this.bookId;
    }
    private String getBookName(){
        return this.bookName;
    }
    private String getBookAuthor(){
        return this.bookAuthor;
    }
    private int getQuantity(){
        return this.quantity;
    }
    private String getStatus(){
        return this.status;
    }

    //Books methods
    public Books addNewBooks(){
        Scanner input = new Scanner(System. in);
        System.out.println("ID of a book:\t");
        int id = input.nextInt();
        System.out.println("Name of a book:\t");
        String name = input.nextLine();
        System.out.println("Author of a book:\t");
        String author = input.nextLine();
        System.out.println("Status of a book:\t");
        String status = input.nextLine();
        return new Books(id, name, author, status);
    }
    public String toString(){
        return String.format("Book ID: %d\nBook Name: %s\nBook Author: %s\nStatus: %b",
                this.getBookId(), this.getBookName(), this.getBookAuthor(), this.getStatus());
    }

}

