package web.DaoCars;


import org.springframework.stereotype.Component;
import web.model.User;

import java.sql.*;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3307/task231";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private static Connection connection;

    static {
//        try {
//            Class.forName("com.mysql.jdbc.Drive");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<User> index() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setbYear(resultSet.getInt("bYear"));
                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User show(int id) {
//        return users.stream()
//                .filter(user -> user.getId() == id)
//                .findAny()
//                .orElse(null);
        return null;
    }
    public void save(User user) {
//        user.setId(++USER_COUNT);
//        users.add(user);
    }

    public void update(int id, User updatedUser) {
//        User userToBeUpdated = show(id);
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setLastName(updatedUser.getLastName());
//        userToBeUpdated.setbYear(updatedUser.getbYear());
    }
    public void delete(int id) {
    //    users.removeIf(u->u.getId()==id);
    }

}
