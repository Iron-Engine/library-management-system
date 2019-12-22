package Users;

import Database.SqlLoginUser;
import javafx.beans.property.SimpleStringProperty;

public class Account {
    private SimpleStringProperty username;
    private SimpleStringProperty password;

    Account(){
        setLogin(null);
        setPassword(null);
    }

    Account(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public void setLogin(String username){ this.username.set(username); }
    public void setPassword(String password){ this.password.set(password); }

    public String getLogin(){ return this.username.get(); }
    public String getPassword(){ return this.password.get(); }

    public int login(String usernameStr, String passwordStr){
        return SqlLoginUser.main(usernameStr, passwordStr);
    }
}
