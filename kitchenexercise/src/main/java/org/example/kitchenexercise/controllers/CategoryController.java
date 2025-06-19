package org.example.kitchenexercise.controllers;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.services.KitchenService;
import org.example.kitchenexercise.services.LocalKitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class CategoryController {

    private final KitchenService kitchenService;

    @Autowired
    public CategoryController(LocalKitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping("/category/list")
    public String listCategory(Model model) {
        model.addAttribute("categories",kitchenService.getCategories());
        model.addAttribute("mode","list");
        return "category/list";
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        model.addAttribute("isExist",false);
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @GetMapping("/category/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        model.addAttribute("isExist", true);
        model.addAttribute("category", kitchenService.getCategory(id));
        return "category/form";
    }

    @PostMapping("/category/update")
    public String updateCategory(@ModelAttribute("category") Category category, Model model) {
        kitchenService.updateCategory(category);
        return "redirect:/category/list";
    }

    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        category.setId(UUID.randomUUID());
        kitchenService.addCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable UUID id, @RequestParam(value = "from") String destination, Model model) {
        kitchenService.deleteCategory(id);
        kitchenService.deleteRecipeByCategory(id);
        return "redirect:"+destination;
    }
}
