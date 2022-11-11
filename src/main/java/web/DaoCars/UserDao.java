package web.DaoCars;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.Arrays;

import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;
    private List<User> users = Arrays.asList(
            new User(++USER_COUNT,"Sergey","Korotich",1985),
            new User(++USER_COUNT,"Anton","Osipov",1995),
            new User(++USER_COUNT,"Владимир","Савельев",1995));

    public List<User> index() {
        return users;
    }

}
