package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DaoCars.UserDao;
import web.model.User;
//@RequestMapping("/users")
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
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("users",new User());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("users") User user) {
        userDao.save(user);
        return "redirect:/users";
    }
}
