package org.example.kitchenexercise.repositories.category;

import org.example.kitchenexercise.models.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class LocalCategoryRepository implements BaseCategoryRepository {

    Map<UUID, Category> categories = new HashMap<>();

    public LocalCategoryRepository() {

    }

    @Override
    public List<Category> get() {
        return categories.values().stream().toList();
    }

    @Override
    public Category get(UUID id) {
        return categories.get(id);
    }

    @Override
    public Category add(Category element) {
        return categories.put(element.getId(), element);
    }

    @Override
    public Category update(Category element) {
        return categories.replace(element.getId(), element);
    }

    @Override
    public void delete(UUID id) {
        categories.remove(id);
    }


}
