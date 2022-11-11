package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.DaoCars.UserDao;

@Controller
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        return "users";
    }
}
