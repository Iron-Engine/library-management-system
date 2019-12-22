package Users;
import Book.Book;
import Database.SqlLoginUser;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Scanner;

public class User {
    private SimpleIntegerProperty id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty type;
    private SimpleStringProperty username;
    private SimpleStringProperty password;

    public Book book;

    public User(){
        setId(0);
        setFirstName("");
        setSecondName("");
        setType("");
        setLogin("");
        setPassword("");
        book = new Book();
    }

    public User(int id, String firstName, String lastName, String type, String username, String password){
        setId(id);
        setFirstName(firstName);
        setSecondName(lastName);
        setType(type);
        setLogin(username);
        setPassword(password);
    }
    // getters
    public int getId(){ return this.id.get(); }
    public String getFirstName(){ return this.firstName.get(); }
    public String getLastName(){ return this.lastName.get(); }
    public String getType(){ return this.type.get(); }
    public String getUsername(){ return this.username.get(); }
    public String getPassword(){ return this.password.get(); }

    // setters
    public void setId(int id){ this.id = new SimpleIntegerProperty(id); }
    private void setFirstName(String firstName){ this.firstName = new SimpleStringProperty(firstName); }
    private void setSecondName(String secondName){ this.lastName = new SimpleStringProperty(secondName); }
    private void setType(String typeStr) { this.type = new SimpleStringProperty(typeStr); }
    public void setLogin(String username){ this.username = new SimpleStringProperty(username); }
    public void setPassword(String password){ this.password = new SimpleStringProperty(password); }

    public int login(String usernameStr, String passwordStr){
        return SqlLoginUser.main(usernameStr, passwordStr);
    }

    public String toString(){
        return String.format("User ID: %d\nUser Firstname: %s\nUser Lastname: %s\nUser Type: %s\n",
                this.getId(), this.getFirstName(), this.getLastName(), this.getType());
    }
}
