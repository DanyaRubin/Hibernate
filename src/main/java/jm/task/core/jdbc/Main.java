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

         final String testName1 = "Ivan";
         final String testLastName1 = "Petrov";
         final byte testAge1 = 5;

         final String testName2 = "Petr";
         final String testLastName2 = "Ivanov";
         final byte testAge2 = 6;

         final String testName3 = "Vasily";
         final String testLastName3 = "Utkin";
         final byte testAge3 = 7;

         final String testName4 = "Utka";
         final String testLastName4 = "Vasilieva";
         final byte testAge4 = 8;

        try {
            userService.createUsersTable();
            userService.saveUser(testName1,testLastName1, testAge1);
            System.out.println("User с именем " + testName1 + " добавлен в базу данных");
            userService.saveUser(testName2,testLastName2, testAge2);
            System.out.println("User с именем " + testName2 + " добавлен в базу данных");
            userService.saveUser(testName3,testLastName3, testAge3);
            System.out.println("User с именем " + testName3 + " добавлен в базу данных");
            userService.saveUser(testName4,testLastName4, testAge4);
            System.out.println("User с именем " + testName4 + " добавлен в базу данных");

            System.out.println (userService.getAllUsers());

            userService.cleanUsersTable();
            userService.dropUsersTable();

        } catch (Exception e) {
            System.out.println("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

}

