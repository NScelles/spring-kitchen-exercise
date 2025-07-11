package org.example.kitchenexercise.repositories.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.repositories.BaseRepository;

import java.util.UUID;

public interface BaseRecipeRepository extends BaseRepository<Recipe> {

    public void deleteByCategory(UUID categoryId);
    public void updateCategory(Category category);
}
