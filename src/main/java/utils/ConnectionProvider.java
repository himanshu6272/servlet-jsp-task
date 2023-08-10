package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionProvider {
    public static Connection getConnection() {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
            String uname = bundle.getString("username");
            String pwd = bundle.getString("password");
            String url = bundle.getString("url");

        Connection connection = null;

        try {
            if (connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, uname,pwd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
