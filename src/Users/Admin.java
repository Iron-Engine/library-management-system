package Users;

import Database.SqlDeleteUser;
import Database.SqlInsertUser;
import Database.SqlModifyUser;
import Database.SqlViewUserType;

public class Admin extends User {
    public Librarian librarian;

    public Admin(){
        super(0, "", "","", "","" );
    }
    // constructor
    public Admin(int id, String firstName, String lastNameStr, String typeStr, String username, String password){ super(id, firstName, lastNameStr, typeStr, username, password);}

//    public String viewAllLibrarians(){ return SqlViewUserType.main("User.Librarian");}

    public void addLibrarian(Librarian librarian){ SqlInsertUser.main(librarian); }
    public void modifyLibrarian(Librarian librarianObj){ SqlModifyUser.main(librarianObj); }
    public void deleteLibrarian( int librarianIdInt){ SqlDeleteUser.main(librarianIdInt); }
}