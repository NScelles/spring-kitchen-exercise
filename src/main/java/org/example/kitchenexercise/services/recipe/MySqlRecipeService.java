package org.example.kitchenexercise.services.recipe;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.services.category.BaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MySqlRecipeService extends BaseRecipeService {

    protected JpaRepository<Category,UUID> categoryRepository;

    @Autowired
    public MySqlRecipeService(JpaRepository<Recipe,UUID> repository, JpaRepository<Category,UUID> categoryRepository) {
        super(repository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteByCategory(UUID categoryId) {
        repository.deleteAll(repository.findAll().stream().filter(r -> r.getCategory().getId().equals(categoryId)).toList());
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
