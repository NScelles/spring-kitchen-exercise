package org.example.kitchenexercise.repositories;

import org.example.kitchenexercise.models.Recipe;

import java.util.List;
import java.util.UUID;


public interface BaseRepository<T> {
    public List<T> get();
    public T get(UUID id);
    public T add(T element);
    public T update(T element);
    public void delete(UUID id);
}
