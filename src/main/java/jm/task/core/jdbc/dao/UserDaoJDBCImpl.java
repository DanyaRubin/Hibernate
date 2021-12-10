package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE users (Id INT PRIMARY KEY AUTO_INCREMENT, testName VARCHAR, testLastName VARCHAR, testAge INT ");
        } catch (SQLException t) {
            t.printStackTrace();
        }
    }


    public void dropUsersTable() {
        try (Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE users ");
        } catch (SQLException t) {
            t.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT users (testName,testLastName,testAge) VALUES (name,lastName,age)");
        } catch (SQLException t) {
            t.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users WHERE Id = id");
        } catch (SQLException t) {
            t.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List <User> userList = new ArrayList<>();
        try (Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

           while (resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString(1));
                user.setLastName(resultSet.getString(2));
                user.setAge(resultSet.getByte(3));
                userList.add(user);
            }

        } catch (SQLException t) {
            t.printStackTrace();
        }

        return userList;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE users ");
                    } catch (SQLException t) {
            t.printStackTrace();
        }
    }
}
