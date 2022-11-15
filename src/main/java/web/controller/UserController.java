package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userDao.show(id));
        return "edit";
    }
    @PatchMapping("{id}")
    public String update (@ModelAttribute("users") User user, @PathVariable("id") int id) {
        userDao.update(id, user);
        return "redirect:/users";
    }
}
