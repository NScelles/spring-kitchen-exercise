package org.example.kitchenexercise.services.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.services.BaseService;
import org.example.kitchenexercise.services.category.BaseCategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseRecipeService extends BaseService<Recipe> {


    public BaseRecipeService(JpaRepository<Recipe,UUID> repository) {
        super(repository);

    }

    public abstract void deleteByCategory(UUID categoryId);
    public abstract List<Category> getCategories();

}
