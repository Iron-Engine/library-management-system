package Database;

import Users.*;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlGetUser {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static User main(int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, login, password, fine, blocked FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userIdInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                switch (resultSet.getString(4)) {
                    case "Users.Admin":
                        return new Admin(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6));
                    case "Users.Librarian":
                        return new Librarian(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6));
                    case "Users.Student":
                        return new Student(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getInt(7),
                                resultSet.getBoolean(8),
                                resultSet.getString(5),
                                resultSet.getString(6));
                }
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
    public static Admin returnAdmin(int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, login, password, fine, blocked FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userIdInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Admin(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
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
    public static Librarian returnLibrarian(int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, login, password, fine, blocked FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userIdInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Librarian(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
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
    public static Student returnStudent(int userIdInt) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName, type, login, password, fine, blocked FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userIdInt);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(7),
                        resultSet.getBoolean(8),
                        resultSet.getString(5),
                        resultSet.getString(6));
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