package Database;

import Book.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlInsertBook {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static void main(Book bookObj) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO books(isbn, subject, author, publishdate, title, borrowerid, status) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, bookObj.getIsbn());
            preparedStatement.setString(2, bookObj.getSubject());
            preparedStatement.setString(3, bookObj.getAuthor());
            preparedStatement.setString(4, bookObj.getPublishDate());
            preparedStatement.setString(5, bookObj.getTitle());
            preparedStatement.setInt(6, bookObj.getBorrowerId());
            preparedStatement.setBoolean(7, bookObj.getStatus());
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

