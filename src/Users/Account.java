package Users;

import Database.SqlLoginUser;

public class Account {
    private String username;
    private String password;

    Account(){
        setLogin(null);
        setPassword(null);
    }

    Account(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public void setLogin(String username){ this.username = username; }
    public void setPassword(String password){ this.password = password; }

    public String getLogin(){ return this.username; }
    public String getPassword(){ return this.password; }

    public int login(String usernameStr, String passwordStr){
        return SqlLoginUser.main(usernameStr, passwordStr);
    }
}
