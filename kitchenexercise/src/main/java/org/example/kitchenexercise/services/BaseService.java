package org.example.kitchenexercise.services;


import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.repositories.BaseRepository;
import org.example.kitchenexercise.repositories.recipe.BaseRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class BaseService<T> {

    protected BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> get(){
        return repository.get();
    }
    public T get(UUID id){
        return repository.get(id);
    }
    public T add(T element){
        return repository.add(element);
    }
    public T update(T element){
        return repository.update(element);
    }

    public void delete(UUID id){
        repository.delete(id);
    }
}
