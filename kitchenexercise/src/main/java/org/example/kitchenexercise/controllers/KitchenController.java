package org.example.kitchenexercise.controllers;

import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.services.KitchenService;
import org.example.kitchenexercise.services.LocalKitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
public class KitchenController {


    private final KitchenService kitchenService;

    @Autowired
    public KitchenController(LocalKitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/recipe/list")
    public String list(Model model) {
        model.addAttribute("mode", "list");
        model.addAttribute("recipes",kitchenService.getRecipes());
        return "recipe/list";
    }

    @GetMapping("/recipe/{id}")
    public String add(@PathVariable UUID id, Model model) {
        model.addAttribute("recipe", kitchenService.getRecipe(id));
        return "recipe/details";
    }

    @GetMapping("/recipe/add")
    public String add(Model model) {
        model.addAttribute("isExist", false);
        model.addAttribute("categories", kitchenService.getCategories());
        model.addAttribute("recipe", new Recipe());
        return "recipe/form";
    }

    @PostMapping("/recipe/add")
    public String add(@ModelAttribute("recipe") Recipe recipe,Model model) {
        recipe.setCategory(kitchenService.getCategory(recipe.getCategoryId()));
        recipe.setId(UUID.randomUUID());
        kitchenService.addRecipe(recipe);
        System.out.println(recipe);
        return "redirect:/recipe/list";
    }

    @GetMapping("/recipe/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        model.addAttribute("isExist", true);
        model.addAttribute("categories", kitchenService.getCategories());
        model.addAttribute("recipe", kitchenService.getRecipe(id));
        return "recipe/form";
    }

    @PostMapping("/recipe/update")
    public String update(@ModelAttribute("recipe") Recipe recipe,Model model) {
        recipe.setCategory(kitchenService.getCategory(recipe.getCategoryId()));
        kitchenService.addRecipe(recipe);
        return "redirect:/recipe/list";
    }

    @GetMapping("/recipe/delete/{id}")
    public String delete(@PathVariable UUID id, @RequestParam(value = "from") String destination, Model model) {
        kitchenService.deleteRecipe(id);
        return "redirect:"+destination;
    }


}
