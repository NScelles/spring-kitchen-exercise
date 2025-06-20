package org.example.kitchenexercise.services.category;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.repositories.BaseRepository;
import org.example.kitchenexercise.repositories.category.BaseCategoryRepository;
import org.example.kitchenexercise.services.BaseService;
import org.example.kitchenexercise.services.recipe.BaseRecipeService;

import java.util.List;
import java.util.UUID;

public abstract class BaseCategoryService extends BaseService<Category> {

    protected BaseCategoryRepository repository;
    protected BaseRecipeService recipeService;

    public BaseCategoryService(BaseCategoryRepository repository, BaseRecipeService recipeService) {
        super(repository);
        this.repository = repository;
        this.recipeService = recipeService;
    }

    @Override
    public List<Category> get() {
        return super.get();
    }

    @Override
    public Category get(UUID id) {
        return super.get(id);
    }

    @Override
    public Category add(Category element) {
        return super.add(element);
    }

    @Override
    public Category update(Category element) {
        return super.update(element);
    }

    @Override
    public void delete(UUID id) {
        super.delete(id);
    }
}
