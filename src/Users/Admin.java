package Users;

import Database.SqlDeleteUser;
import Database.SqlInsertUser;
import Database.SqlModifyUser;
import Database.SqlViewUserType;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Admin extends User {
    public Librarian librarian;

    public Admin(){
        super(0, "", "","", "","" );
    }
    // constructor
    public Admin(int id, String firstName, String lastName, String type, String username, String password)
    { super(id, firstName, lastName, type, username, password);}

    public void addLibrarian(Librarian librarian){ SqlInsertUser.main(librarian); }
    public void modifyLibrarian(Librarian librarianObj){ SqlModifyUser.main(librarianObj); }
    public void deleteLibrarian( int librarianIdInt){ SqlDeleteUser.main(librarianIdInt); }
}