package Users;

import Database.SqlReserveBook;
import Database.SqlViewAllBook;

public class Student extends User{
    private int fine;
    private boolean blocked;

    // default constructor
    public Student(){ super(); setFine(0); setBlocked(false);}

    // constructor
    public Student(int id, String firstNameStr, String lastNameStr, String typeStr, int fineInt, boolean blockedBool, String usernameStr, String passwordStr){
        super(id, firstNameStr, lastNameStr, typeStr, usernameStr, passwordStr);
        setFine(fineInt);
        setBlocked(blockedBool);
    }

    // setters
    public void setFine(int fine){ this.fine = fine; }
    private void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    //getters
    public boolean getBlocked(){ return this.blocked; }
    public int getFine(){ return this.fine; }

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
