package org.example.kitchenexercise.controllers;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.services.BaseService;
import org.example.kitchenexercise.services.category.LocalCategoryService;
import org.example.kitchenexercise.services.recipe.BaseRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/recipe")
public class RecipeController extends BaseController<Recipe> {

    private BaseRecipeService service;

    @Autowired
    public RecipeController(BaseRecipeService baseRecipeService) {
        service = baseRecipeService;
    }

    @Override
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("mode", "list");
        model.addAttribute("recipes",service.get());
        return "recipe/list";
    }

    @Override
    @GetMapping("/{id}")
    public String show(@PathVariable UUID id, Model model) {
        model.addAttribute("recipe", service.get(id));
        return "recipe/details";
    }

    @Override
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("isExist", false);
        model.addAttribute("categories", service.getCategories() != null ? service.getCategories() : new ArrayList<Category>());
        model.addAttribute("recipe", new Recipe());
        return "recipe/form";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(@PathVariable UUID id, Model model){
        model.addAttribute("isExist", true);
        model.addAttribute("categories", service.getCategories() != null ? service.getCategories() : new ArrayList<Category>());
        model.addAttribute("recipe", service.get(id));
        return "recipe/form";
    }


    @Override
    @PostMapping("/add")
    public String addElement(@ModelAttribute Recipe element) {
        service.addOrUpdate(element);
        return "redirect:/recipe/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id,  @RequestParam(value = "from",required = false) String destination, Model model) {
        service.delete(id);
        if(destination != null && !destination.isEmpty())
            return "redirect:"+destination;
        return "redirect:/recipe/list";
    }
}
