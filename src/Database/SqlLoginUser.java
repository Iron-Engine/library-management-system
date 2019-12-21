package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlLoginUser {

    private static final String URL = "jdbc:mysql://remotemysql.com:3306/WmkvokN2BI";
    private static final String USER = "WmkvokN2BI";
    private static final String PASSWORD = "4ex9HBssOm";

    public static int main(String userLoginStr, String userPasswordStr) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT id FROM users WHERE login = ? and password = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userLoginStr);
            preparedStatement.setString(2, userPasswordStr);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
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
        return 0;
    }
}

