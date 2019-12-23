package Database;

import Book.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlViewAllBook {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static ObservableList<Book> main() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String str = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT All ISBN, title, author, subject, publishDate, borrowerId, status from books";

            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Book> books = FXCollections.observableArrayList();

            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getBoolean(7)));
            }
            return books;
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
