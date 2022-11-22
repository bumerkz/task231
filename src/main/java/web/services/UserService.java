package web.services;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> index();
    User show(int id);
    public void save(User user);
    public void update(int id, User updatedUser);
    public void delete(int id);
}
