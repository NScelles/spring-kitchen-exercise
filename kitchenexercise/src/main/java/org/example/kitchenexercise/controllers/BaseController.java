package org.example.kitchenexercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public abstract class BaseController<T>{


    @GetMapping("/list")
    public abstract String list(Model model);

    @GetMapping("/{id}")
    public abstract String show(@PathVariable UUID id, Model model);

    @GetMapping("/add")
    public abstract String add(Model model);

    @GetMapping("/update/{id}")
    public abstract String update(@PathVariable UUID id, Model model);


    @PostMapping("/add")
    public abstract String addElement(@ModelAttribute T element);

    @GetMapping("/delete/{id}")
    public abstract String delete(@PathVariable UUID id, @RequestParam(value = "from") String destination, Model model);

}
