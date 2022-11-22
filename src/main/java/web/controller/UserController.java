package web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.services.UserService;
//@RequestMapping("/users")
@Controller
public class UserController {
    //private final UserDao userDao;
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        //    addUsers();
    }
//    private void addUsers() {
//        userService.save(new User("Sergey", "Korotich", 1985));
//        userService.save(new User("Anton", "Осипов", 1984));
//        userService.save(new User("Алексей", "Monchev", 2002));
//    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("users",new User());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("users") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userService.show(id));
        return "edit";
    }
    @PatchMapping("users/{id}")
    public String update (@ModelAttribute("users") @Valid User user, BindingResult bindingResult,
                          @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(id, user);
        return "redirect:/users";
    }
    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.show(id));
        return "show";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
