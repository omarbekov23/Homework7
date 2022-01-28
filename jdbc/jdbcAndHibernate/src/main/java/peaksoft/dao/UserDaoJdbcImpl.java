package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    Util util = new Util();
    ArrayList<User> list = new ArrayList<>();

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE users" +
                "(id SERIAL PRIMARY KEY, " +
                "name VARCHAR(50)NOT NULL," +
                "last_Name VARCHAR(50)NOT NULL," +
                "age VARCHAR(50)NOT NULL);";
        try {
            Connection connection = Util.connection();
            Statement sts = connection.createStatement();
            sts.executeUpdate(SQL);
            System.out.println("You created a table:");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE users";
        try {
            Connection conn = Util.connection();
            Statement stst = conn.createStatement();
            stst.executeUpdate(SQL);
            System.out.println("You deleted the table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String last_Name, byte age) {
        String SQL = " INSERT INTO users (name,last_Name,age) VALUES (?,?,?) ";
        try {
            PreparedStatement stst = Util.connection().prepareStatement(SQL);
            stst.setString(1, name);
            stst.setString(2, last_Name);
            stst.setInt(3, age);
            stst.executeUpdate();
            System.out.println("Information saved!");
        } catch (SQLException e) {
            System.out.println("Information not saved!");
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement = Util.connection()
                    .prepareStatement("delete from users where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            System.out.println(id + " Deleted ");
        } catch (SQLException e) {
            System.out.println("Table does not exist");
        }
    }

    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM users";
        try (Connection connection = Util.connection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLast_Name(rs.getString("last_Name"));
                user.setAge(rs.getByte("age"));
                list.add(user);
            }
            System.out.println("Operation completed:");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cleanUsersTable() {
        String SQL = "DELETE FROM users ";
        try (Connection conn = Util.connection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Numbered table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}