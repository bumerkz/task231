package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User show(int id);
    void save(User user);
    void update(User updatedUser);
    void delete(int id);
}
