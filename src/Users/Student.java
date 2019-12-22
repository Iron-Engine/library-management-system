package Users;

import Database.SqlReserveBook;
import Database.SqlViewAllBook;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student extends User{
    private SimpleIntegerProperty fine;
    private SimpleBooleanProperty blocked;

    // default constructor
    public Student(){ super(); fine = null; blocked = null;}

    // constructor
    public Student(int id, String firstName, String lastName, String type, int fine, boolean blocked, String username, String password){
        super(id, firstName, lastName, type, username, password);
        setFine(fine);
        setBlocked(blocked);
    }

    // setters
    public void setFine(int fine){ this.fine.set(fine); }
    private void setBlocked(boolean blocked) { this.blocked.set(blocked); }

    //getters
    public boolean getBlocked(){ return this.blocked.get(); }
    public int getFine(){ return this.fine.get(); }

    public String viewPersonalDetails(){ return this.toString(); }
    public int viewCurrentFine(){ return this.getFine(); }
    public void viewBorrowedBooks(){}
    public boolean reserveBorrowedBook(int bookIsbnInt){
        return SqlReserveBook.main(bookIsbnInt, this.getId());
    }
//    public String viewAllBook(){ return SqlViewAllBook.main(); }

    public String toString(){
        return super.toString()
            + String.format("User Fine: %d\n", this.getFine())
            + String.format("User Blocked: %b\n", this.getBlocked());
    }
}
