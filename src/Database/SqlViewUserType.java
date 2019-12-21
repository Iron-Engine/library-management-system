package Database;

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

    public static String main(String userTypeStr) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String str = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id, firstName, lastName FROM users WHERE type = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userTypeStr);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                str += String.format("User ID: %d\nUser Firstname: %s\nUser Lastname: %s\n",
                        resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
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
