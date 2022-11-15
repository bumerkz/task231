package web.DaoCars;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT,"Sergey","Korotich",1985));
        users.add(new User(++USER_COUNT,"Anton","Osipov",1995));
        users.add(new User(++USER_COUNT,"Владимир","Савельев",1995));

    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }
    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setbYear(updatedUser.getbYear());
    }
}
