package ru.ageevvo.crud_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ageevvo.crud_spring_boot.models.User;
import ru.ageevvo.crud_spring_boot.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            userService.saveUser(user);
            return "redirect:/";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.saveUser(user);
            return "redirect:/";
        }
    }
}
