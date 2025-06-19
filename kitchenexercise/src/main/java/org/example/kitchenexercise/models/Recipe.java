package org.example.kitchenexercise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    private UUID id;

    private String name;

    //@OneToMany(mappedBy = "recipe")
    private List<String> steps;

    //@OneToMany(mappedBy = "recipe")
    private List<String> ingredients;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    private UUID categoryId;

}
