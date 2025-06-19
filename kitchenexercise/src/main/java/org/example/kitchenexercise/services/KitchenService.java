package org.example.kitchenexercise.services;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;

import java.util.List;
import java.util.UUID;

public interface KitchenService {

    public List<Recipe> getRecipes();
    public Recipe getRecipe(UUID id);
    public Recipe addRecipe(Recipe recipe);
    public Recipe updateRecipe(Recipe recipe);
    public List<Recipe> getRecipesByName(List<Recipe> recipeList, String name);
    public void deleteRecipe(UUID id);

    public List<Category> getCategories();
    public Category getCategory(UUID id);
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public List<Category> getCategoriesByName(List<Category> categoryList, String name);
    public void deleteCategory(UUID id);
    public void deleteRecipeByCategory(UUID id);
}
