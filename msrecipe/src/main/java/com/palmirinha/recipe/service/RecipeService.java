package com.palmirinha.recipe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmirinha.recipe.model.Recipe;
import com.palmirinha.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {
	
	@Autowired
	private final RecipeRepository recipeRepository;
	
	public Recipe getRecipeById(Long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		return recipe.get();
	}

}
