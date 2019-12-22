package Users;
import Book.Book;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Scanner;

public class User {
    private SimpleIntegerProperty id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty type;

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
    public int getId(){ return this.id.get(); }
    public String getFirstName(){ return this.firstName.get(); }
    public String getLastName(){ return this.lastName.get(); }
    public String getType(){ return this.type.get(); }

    // setters
    public void setId(int id){ this.id.set(id); }
    private void setFirstName(String firstName){ this.firstName.set(firstName); }
    private void setSecondName(String secondName){ this.lastName.set(secondName); }
    private void setType(String typeStr) { this.type.set(typeStr); }

    public String toString(){
        return String.format("User ID: %d\nUser Firstname: %s\nUser Lastname: %s\nUser Type: %s\n",
                this.getId(), this.getFirstName(), this.getLastName(), this.getType());
    }
}
