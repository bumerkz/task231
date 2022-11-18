package web.DaoCars;


import org.springframework.stereotype.Component;
import web.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Connection;
import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3307/task231";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        User user = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastName"));
            user.setbYear(resultSet.getInt("bYear"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public void save(User user) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users VALUES(1,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getbYear());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, User updatedUser) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE user SET name=?, age=?, email=? WHERE id=?");
            preparedStatement.setString(1, updatedUser.getName());
            preparedStatement.setString(2, updatedUser.getLastName());
            preparedStatement.setInt(3, updatedUser.getbYear());
            preparedStatement.setInt(4, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
    //    users.removeIf(u->u.getId()==id);
    }

}
