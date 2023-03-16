package com.palmirinha.recipe.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredient-recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientRecipe {

    @EmbeddedId
    private IngredientRecipeFK IngredientRecipeId;
    private String amount;
    private String measurementId;

}
