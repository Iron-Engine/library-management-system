package Database;

import Book.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlModifyBook {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static void main(Book bookObj) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE books SET title = ?, author = ?, subject = ?, publishDate = ?, borrowerId = ?, status = ? WHERE ISBN = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookObj.getTitle());
            preparedStatement.setString(2, bookObj.getAuthor());
            preparedStatement.setString(3, bookObj.getSubject());
            preparedStatement.setString(4, bookObj.getPublishDate());
            preparedStatement.setInt(5, bookObj.getBorrowerId());
            preparedStatement.setBoolean(6, bookObj.getStatus());
            preparedStatement.setInt(7, bookObj.getIsbn());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

            Logger logger = Logger.getLogger(Database.SqlModifyUser.class.getName());
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

                Logger logger = Logger.getLogger(Database.SqlModifyUser.class.getName());
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

}
