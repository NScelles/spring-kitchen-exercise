package org.example.kitchenexercise.services.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Ingredient;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.repositories.category.LocalCategoryRepository;
import org.example.kitchenexercise.repositories.recipe.LocalRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocalRecipeService extends BaseRecipeService {

    public LocalRecipeService() {
        super(new LocalRecipeRepository(),new LocalCategoryRepository());

        Recipe recipe1 = Recipe.builder().id(UUID.randomUUID())
                .category(Category.builder().id(UUID.fromString("2c4edc43-3e1b-4079-8f53-cd263288afb3")).name("Category 1").description("AZERTYUIOP").build())
                .categoryId(UUID.fromString("2c4edc43-3e1b-4079-8f53-cd263288afb3"))
                .ingredients(List.of("Ingredient 1", "Ingredient 2", "Ingredient 3"))
                .name("Recipe 1")
                .steps(List.of("Step 1", "Step 2", "Step 3"))
                .build();

        Recipe recipe2 = Recipe.builder().id(UUID.randomUUID())
                .category(Category.builder().id(UUID.fromString("c1fcbc0f-670f-4004-93c6-0fa6eea8f344")).name("Category 2").description("QSDFGHJKLM").build())
                .categoryId(UUID.fromString("c1fcbc0f-670f-4004-93c6-0fa6eea8f344"))
                .ingredients(List.of("Ingredient 1", "Ingredient 2", "Ingredient 3"))
                .name("Recipe 2")
                .steps(List.of("Step 1", "Step 2", "Step 3"))
                .build();

        repository.add(recipe1);
        repository.add(recipe2);

    }

    @Override
    public void deleteByCategory(UUID categoryId) {
        repository.deleteByCategory(categoryId);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.get();
    }

    @Override
    public void updateCategory(Category category) {
        repository.updateCategory(category);
    }
}
