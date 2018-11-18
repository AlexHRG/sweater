package com.example.sweater.controller;

import com.example.sweater.domain.Bird;
import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.BirdRepo;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BirdRepo birdRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        Iterable<Bird> birds = birdRepo.findAll();

        model.put("users", users);
        model.put("birds", birds);
        return "main";
    }

    @PostMapping("filter")
    public String filter (@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> filteredUsers;

        if (filter != null && !filter.isEmpty()) {
            filteredUsers = userRepo.findByRoles(Role.valueOf(filter));
        } else {
            filteredUsers = userRepo.findAll();
        }

        model.put("users", filteredUsers);

        return "main";
    }
}
