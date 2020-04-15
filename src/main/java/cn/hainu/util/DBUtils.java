package cn.hainu.util;
import java.sql.*;

public class DBUtils {

    private static Connection connection = null;
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/userinfo?serverTimezone=UTC";
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static void closeConnection()
    {
        if(connection != null)
        {
            try {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
