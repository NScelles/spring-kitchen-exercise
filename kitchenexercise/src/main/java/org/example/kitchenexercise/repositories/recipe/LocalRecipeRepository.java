package org.example.kitchenexercise.repositories.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LocalRecipeRepository implements BaseRecipeRepository {
    Map<UUID, Recipe> recipes = new HashMap<>();

    @Override
    public List<Recipe> get() {
        return recipes.values().stream().toList();
    }

    @Override
    public Recipe get(UUID id) {
        return recipes.get(id);
    }

    @Override
    public Recipe add(Recipe element) {
        return recipes.put(element.getId(), element);
    }

    @Override
    public Recipe update(Recipe element) {
        return recipes.replace(element.getId(), element);
    }

    @Override
    public void delete(UUID id) {
        recipes.remove(id);
    }

    @Override
    public void deleteByCategory(UUID categoryId) {
        for (Recipe r : recipes.values().stream().filter(r->r.getCategoryId().equals(categoryId)).toList()) {
            recipes.remove(r.getId());
        }
    }

    @Override
    public void updateCategory(Category category) {
        for (Recipe r : recipes.values().stream().filter(r->r.getCategoryId().equals(category.getId())).toList()) {
            r.setCategory(category);
        }
    }
}
