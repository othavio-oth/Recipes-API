package com.palmirinha.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palmirinha.recipe.model.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
