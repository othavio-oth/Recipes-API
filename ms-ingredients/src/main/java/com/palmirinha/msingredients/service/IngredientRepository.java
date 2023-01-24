package com.palmirinha.msingredients.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palmirinha.msingredients.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
