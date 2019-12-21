package Users;

import Book.Book;
import Database.*;

public class Librarian extends User{

    public Student student;

    // default constructor
    public Librarian(){ super(); }

    // constructor
    public Librarian(int id, String firstNameStr, String lastNameStr, String typeStr, String usernameStr, String passwordStr){
        super(id, firstNameStr, lastNameStr, typeStr, usernameStr, passwordStr);
    }

    public void blockStudent(int userIdInt){ SqlBlockUser.main(userIdInt); }
    public void returnBorrowedBooks(int bookIsbnInt){ SqlReturnBook.main(bookIsbnInt); }
    public void issueFine(int fineInt, int userIdInt){ SqlIssueFine.main(fineInt, userIdInt); }

//    public String viewAllStudents(){ return SqlViewUserType.main("User.Student");}

    public void addStudent(Student student){ SqlInsertUser.main(student); }
    public void modifyStudent(Student studentObj){ SqlModifyUser.main(studentObj); }
    public void deleteStudent( int studentIdInt){ SqlDeleteUser.main(studentIdInt);}

    public void addBook(Book book){ SqlInsertBook.main(book); }
    public void modifyBook(Book book){ SqlModifyBook.main(book); }
    public void deleteBook(int bookIsbnInt){ SqlDeleteBook.main(bookIsbnInt); }
}
