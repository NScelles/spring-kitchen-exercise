package org.example.kitchenexercise.services.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.repositories.category.BaseCategoryRepository;
import org.example.kitchenexercise.repositories.recipe.BaseRecipeRepository;
import org.example.kitchenexercise.services.BaseService;

import java.util.List;
import java.util.UUID;

public abstract class BaseRecipeService extends BaseService<Recipe> {

    protected BaseRecipeRepository repository;
    protected BaseCategoryRepository categoryRepository;

    public BaseRecipeService(BaseRecipeRepository repository, BaseCategoryRepository categoryRepository) {
        super(repository);
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public abstract void deleteByCategory(UUID categoryId);
    public abstract List<Category> getCategories();
    public abstract void updateCategory(Category category);
}
