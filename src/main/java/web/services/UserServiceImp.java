package web.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
@Transactional

public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);

    }
    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }








}
