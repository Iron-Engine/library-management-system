package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlDeleteBook {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static void main(int isbnInt){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "DELETE FROM books WHERE ISBN = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, isbnInt);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

            Logger logger = Logger.getLogger(SqlDeleteUser.class.getName());
            logger.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {

                Logger logger = Logger.getLogger(SqlDeleteUser.class.getName());
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

}

