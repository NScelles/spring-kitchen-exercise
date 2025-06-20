package org.example.kitchenexercise.repositories.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LocalRecipeRepository {
    Map<UUID, Recipe> recipes = new HashMap<>();


    public List<Recipe> get() {
        return recipes.values().stream().toList();
    }


    public Recipe get(UUID id) {
        return recipes.get(id);
    }


    public Recipe add(Recipe element) {
        return recipes.put(element.getId(), element);
    }


    public Recipe update(Recipe element) {
        return recipes.replace(element.getId(), element);
    }


    public void delete(UUID id) {
        recipes.remove(id);
    }


    public void deleteByCategory(UUID categoryId) {
        for (Recipe r : recipes.values().stream().filter(r->r.getCategory().getId().equals(categoryId)).toList()) {
            recipes.remove(r.getId());
        }
    }


    public void updateCategory(Category category) {
        for (Recipe r : recipes.values().stream().filter(r->r.getCategory().getId().equals(category.getId())).toList()) {
            r.setCategory(category);
        }
    }
}
