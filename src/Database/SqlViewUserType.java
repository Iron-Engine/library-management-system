package Database;

import Book.Book;
import Users.Admin;
import Users.Librarian;
import Users.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlViewUserType {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static ObservableList<Admin> admin() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, login, password FROM users WHERE type = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Users.Admin");

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Admin> admins = FXCollections.observableArrayList();

            while (resultSet.next()) {
                admins.add(new Admin(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
            return admins;
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
    public static ObservableList<Librarian> librarian() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, login, password FROM users WHERE type = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Users.Librarian");

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Librarian> librarians = FXCollections.observableArrayList();

            while (resultSet.next()) {
                librarians.add(new Librarian(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
            return librarians;
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
    public static ObservableList<Student> student() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, fine, blocked, login, password FROM users WHERE type = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Users.Student");

            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<Student> student = FXCollections.observableArrayList();

            while (resultSet.next()) {
                student.add(new Student(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getBoolean(6),
                        resultSet.getString(7),
                        resultSet.getString(8)));
            }
            return student;
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
