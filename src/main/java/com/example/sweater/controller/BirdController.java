package com.example.sweater.controller;

import com.example.sweater.domain.Bird;
import com.example.sweater.repos.BirdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BirdController {
    @Autowired
    BirdRepo birdRepo;

    @PostMapping("/addbird")
    public String addBird(@RequestParam String birdName, Map<String, Object> model) {
        Bird birdFromDb = birdRepo.findByName(birdName);

        if(birdFromDb != null) {
            model.put("message", "Придумай новое имя!");
            return "redirect:/main";
        }

        Bird bird = new Bird();
        bird.setName(birdName);

        birdRepo.save(bird);
        return "redirect:/main";
    }
}
