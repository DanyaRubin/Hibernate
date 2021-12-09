package jm.task.core.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() throws SQLException{
 //       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "3344122")) {
   //         Statement statement = connection.createStatement();
     //   } catch (SQLException e) {
       //     e.printStackTrace();
        String url = "jdbc:mysql://localhost/test";
        String username = "root";
        String password = "3344122";
        return DriverManager.getConnection(url, username, password);
    }
}
