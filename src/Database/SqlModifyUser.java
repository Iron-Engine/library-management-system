package Database;

import Users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlModifyUser {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static void main(User userObj) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE users SET firstName = ?, lastName = ?, login = ?, password = ? WHERE Id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userObj.getFirstName());
            preparedStatement.setString(2, userObj.getLastName());
            preparedStatement.setString(3, userObj.account.getLogin());
            preparedStatement.setString(4, userObj.account.getPassword());
            preparedStatement.setInt(5, userObj.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

            Logger logger = Logger.getLogger(SqlModifyUser.class.getName());
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

                Logger logger = Logger.getLogger(SqlModifyUser.class.getName());
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

}

