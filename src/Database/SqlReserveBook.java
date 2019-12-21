package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlReserveBook {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static boolean main(int bookIsbnInt, int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT status FROM books WHERE ISBN = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookIsbnInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.getBoolean(1)) {
                String query2 = "UPDATE books SET status = false, borrowerId = ?  WHERE ISBN = ?";
                preparedStatement = connection.prepareStatement(query2);
                preparedStatement.setInt(1, userIdInt);
                preparedStatement.setInt(2, bookIsbnInt);
                preparedStatement.executeUpdate();
                return true;
            }

        } catch (SQLException ex) {

            Logger logger = Logger.getLogger(SqlLoginUser.class.getName());
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

                Logger logger = Logger.getLogger(SqlLoginUser.class.getName());
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return false;
    }
}
