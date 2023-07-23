package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection connection;

    public static Connection getConnection() {

        try {
            if (connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root","Vinay@163");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
