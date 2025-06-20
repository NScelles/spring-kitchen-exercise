package org.example.kitchenexercise.services.category;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.repositories.category.LocalCategoryRepository;
import org.example.kitchenexercise.repositories.recipe.LocalRecipeRepository;
import org.example.kitchenexercise.services.BaseService;
import org.example.kitchenexercise.services.recipe.LocalRecipeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocalCategoryService extends BaseCategoryService {

    public LocalCategoryService() {
        super(new LocalCategoryRepository(),new LocalRecipeService());

       Category cat1 = Category.builder().id(UUID.fromString("2c4edc43-3e1b-4079-8f53-cd263288afb3")).name("Category 1").description("AZERTYUIOP").build();
       Category cat2 = Category.builder().id(UUID.fromString("c1fcbc0f-670f-4004-93c6-0fa6eea8f344")).name("Category 2").description("QSDFGHJKLM").build();

       repository.add(cat1);
       repository.add(cat2);
    }

    @Override
    public void delete(UUID id) {
        super.delete(id);
        recipeService.deleteByCategory(id);
    }

    @Override
    public Category update(Category element) {
        recipeService.updateCategory(element);
        return super.update(element);
    }
}
