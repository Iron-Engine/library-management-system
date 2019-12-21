package Users;
import Book.Book;

import java.util.Scanner;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String type;

    public Book book;
    public Account account;

    public User(){
        setId(0);
        setFirstName("");
        setSecondName("");
        setType("");
        account = new Account();
        book = new Book();
    }

    public User(int id, String firstName, String lastName, String type, String username, String password){
        setId(id);
        setFirstName(firstName);
        setSecondName(lastName);
        setType(type);
        account = new Account(username, password);
    }
    // getters
    public int getId(){ return this.id; }
    public String getFirstName(){ return this.firstName; }
    public String getLastName(){ return this.lastName; }
    public String getType(){ return this.type; }

    // setters
    public void setId(int id){ this.id = id; }
    private void setFirstName(String firstName){ this.firstName = firstName; }
    private void setSecondName(String secondName){ this.lastName = secondName; }
    private void setType(String typeStr) { this.type = typeStr; }

    public String toString(){
        return String.format("User ID: %d\nUser Firstname: %s\nUser Lastname: %s\nUser Type: %s\n",
                this.getId(), this.getFirstName(), this.getLastName(), this.getType());
    }
}
