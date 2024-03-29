package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String printUsers(Model model) {
        model.addAttribute("users", userService.printAllUsers());
        return "user";
    }
    @GetMapping("/add")
    public String addUserWeb(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }
    @PostMapping("/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String editUserWeb(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/users";
    }
}
