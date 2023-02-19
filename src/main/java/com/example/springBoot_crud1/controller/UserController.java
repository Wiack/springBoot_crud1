package com.example.springBoot_crud1.controller;

import com.example.springBoot_crud1.model.User;
import com.example.springBoot_crud1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap model) {
        List<User> list = userService.getUsers();
        model.addAttribute("listUsers", list);
        return "allUser";
    }

    @GetMapping("/newUser")
    public String getCreationForm(Model model) {
        model.addAttribute("user", new User());
        return "detailsNewUser";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/editInfo/{id}")
    public String getEditingForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editInfoUser";
    }


    @PostMapping("/updeteInfo")
    public String saveEditInfoUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}