package web.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DaoCars.UserDaoInt;
import web.model.User;

import java.util.List;
@Service
@Transactional

public class UserServiceImp implements UserService {
    private final UserDaoInt userDaoInt;

    public UserServiceImp(UserDaoInt userDaoInt) {
        this.userDaoInt = userDaoInt;
    }

    @Override
    public void save(User user) {
        userDaoInt.save(user);
    }
    @Override
    public void delete(int id) {
        userDaoInt.delete(id);
    }
    @Override
    public void update(int id, User updatedUser) {
        userDaoInt.update(id, updatedUser);

    }
    @Override
    public User show(int id) {
        return userDaoInt.show(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDaoInt.index();
    }








}
