package org.example.kitchenexercise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Step {

    private UUID id;
    private String description;
    private Integer order;

//    @ManyToOne
//    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", order=" + order +
                '}';
    }
}
