package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
         final UserService userService = new UserServiceImpl();

         final String testName = "Ivan";
         final String testLastName = "Ivanov";
         final byte testAge = 5;

        try {
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);


        } catch (Exception e) {
            System.out.println("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

}

