package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root",
                    "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
