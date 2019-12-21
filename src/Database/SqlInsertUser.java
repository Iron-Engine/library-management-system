package Database;

import Users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlInsertUser {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static void main(User userObj) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(firstName, lastName, type, login, password, fine) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, userObj.getFirstName());
            preparedStatement.setString(2, userObj.getLastName());
            preparedStatement.setString(3, userObj.getClass().getName());
            preparedStatement.setString(4, userObj.account.getLogin());
            preparedStatement.setString(5, userObj.account.getPassword());
            preparedStatement.setInt(6, 0);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

            Logger logger = Logger.getLogger(SqlInsertUser.class.getName());
            logger.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

            } catch (SQLException ex) {

                Logger logger = Logger.getLogger(SqlInsertUser.class.getName());
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
