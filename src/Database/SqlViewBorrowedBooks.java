package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlViewBorrowedBooks {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static String main(int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String str = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT ISBN, title, author, subject, publishDate, status from books WHERE borrowerId = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userIdInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                 str += String.format("ISBN: %d\nTitle: %s\nAuthor: %s\nSubject: %s\nPublish Date: %s\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }
            return str;

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

                Logger logger = Logger.getLogger(SqlLoginUser.class.getName());
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return null;
    }
}
