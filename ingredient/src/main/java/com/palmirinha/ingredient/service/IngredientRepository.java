package com.palmirinha.ingredient.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palmirinha.ingredient.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
