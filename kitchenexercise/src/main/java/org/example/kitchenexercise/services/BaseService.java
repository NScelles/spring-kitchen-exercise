package org.example.kitchenexercise.services;


import org.example.kitchenexercise.models.Recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BaseService<T> {

    Map<UUID,T> list = new HashMap<>();
    public List<T> get(){
        return list.values().stream().toList();
    }
    public T get(UUID id){
        return list.get(id);
    }
    public T add(T element, UUID id){
        return list.put(id, element);
    }
    public T update(T element, UUID id){
        return list.put(id, element);
    }

    public void delete(UUID id){
        list.remove(id);
    }
}
