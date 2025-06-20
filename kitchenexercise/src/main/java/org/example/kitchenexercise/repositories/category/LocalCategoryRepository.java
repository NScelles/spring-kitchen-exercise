package org.example.kitchenexercise.repositories.category;

import org.example.kitchenexercise.models.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class LocalCategoryRepository  {

    Map<UUID, Category> categories = new HashMap<>();

    public LocalCategoryRepository() {

    }

    public List<Category> get() {
        return categories.values().stream().toList();
    }


    public Category get(UUID id) {
        return categories.get(id);
    }


    public Category add(Category element) {
        return categories.put(element.getId(), element);
    }


    public Category update(Category element) {
        return categories.replace(element.getId(), element);
    }

    public void delete(UUID id) {
        categories.remove(id);
    }


}
