package org.example.kitchenexercise.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public class BaseService<T> {

    protected JpaRepository<T,UUID> repository;


    public BaseService(JpaRepository<T,UUID> repository) {
        this.repository = repository;
    }

    public List<T> get(){
        return repository.findAll();
    }
    public T get(UUID id){
        return repository.getReferenceById(id);
    }
    public T addOrUpdate(T element){
        return repository.save(element);
    }

    public void delete(UUID id){
        repository.delete(get(id));
    }
}
