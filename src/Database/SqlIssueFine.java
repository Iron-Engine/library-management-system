package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlIssueFine {
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static void main(int fineInt, int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT fine FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userIdInt);

            ResultSet resultSet = preparedStatement.executeQuery();
            int currentFine = resultSet.getInt(1);

            String query2 = "UPDATE users SET fine = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setInt(1, currentFine + fineInt);
            preparedStatement.setInt(2, userIdInt);

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
