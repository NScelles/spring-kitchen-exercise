package org.example.kitchenexercise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    //@OneToMany(mappedBy = "recipe")
    private List<String> steps;

    //@OneToMany(mappedBy = "recipe")
    private List<String> ingredients;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //private UUID categoryId;

}
