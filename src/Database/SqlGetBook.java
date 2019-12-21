package Database;

import Book.Book;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlGetBook {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static Book main(int bookIsbnInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT title, author, publishDate, subject, borrowerId, status FROM books WHERE ISBN = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookIsbnInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                        return new Book(
                                bookIsbnInt,
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getInt(5),
                                resultSet.getBoolean(6));
            }

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
