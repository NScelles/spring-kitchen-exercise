package org.example.kitchenexercise.services;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Ingredient;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.models.Step;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocalKitchenService implements KitchenService {

    private BaseService<Category> categoryService = new LocalCategoryService();
    private BaseService<Recipe> recipeService = new LocalRecipeService();

    public LocalKitchenService() {


        Step step1 = Step.builder().id(UUID.randomUUID()).description("Step 1").order(1).build();
        Step step2 = Step.builder().id(UUID.randomUUID()).description("Step 2").order(2).build();

        List<String> steps = Arrays.asList("step1", "step2");

        Ingredient ingredient1 = Ingredient.builder().id(UUID.randomUUID()).name("Ingredient1").quantity("3kg").build();
        Ingredient ingredient2 = Ingredient.builder().id(UUID.randomUUID()).name("Ingredient2").quantity("80g").build();

        List<String> ingredients = Arrays.asList("ingredient1", "ingredient2");

        Category cat1 = Category.builder().id(UUID.randomUUID()).name("Cat1").build();
        Category cat2 = Category.builder().id(UUID.randomUUID()).name("Cat2").build();

        Recipe r1 = Recipe.builder().id(UUID.randomUUID()).name("R1").category(cat1).steps(steps).ingredients(ingredients).build();
        Recipe r2 = Recipe.builder().id(UUID.randomUUID()).name("R2").category(cat2).steps(steps).ingredients(ingredients).build();

        recipeService.list.put(r1.getId(), r1);
        recipeService.list.put(r2.getId(), r2);

        categoryService.list.put(cat1.getId(), cat1);
        categoryService.list.put(cat2.getId(), cat2);

    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeService.get();
    }

    @Override
    public Recipe getRecipe(UUID id) {
        return recipeService.get(id);
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeService.add(recipe,recipe.getId());
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return recipeService.update(recipe,recipe.getId());
    }

    @Override
    public List<Recipe> getRecipesByName(List<Recipe> recipeList, String name) {
        return recipeList.stream().filter(r -> r.getName().startsWith(name)).toList();
    }

    @Override
    public void deleteRecipe(UUID id) {
        recipeService.delete(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryService.get();
    }

    @Override
    public Category getCategory(UUID id) {
        return categoryService.get(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryService.add(category,category.getId());
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryService.update(category,category.getId());
    }

    @Override
    public List<Category> getCategoriesByName(List<Category> categoryList, String name) {
        return categoryList.stream().filter(c -> c.getName().startsWith(name)).toList();
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryService.delete(id);
    }

    public void deleteRecipeByCategory(UUID id){
        var recipeList = recipeService.list.values().stream().filter(r->r.getCategoryId().equals(id)).toList();
        for(Recipe r : recipeList)
            recipeService.delete(r.getId());
    }
}
