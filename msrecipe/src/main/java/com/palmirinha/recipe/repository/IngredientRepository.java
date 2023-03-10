package com.palmirinha.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palmirinha.recipe.model.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
