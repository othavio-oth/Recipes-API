package com.palmirinha.recipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmirinha.recipe.model.Recipe;
import com.palmirinha.recipe.repository.RecipeRepository;

@Service
public class RecipeService {

    public class IngredientService {

        @Autowired
        private final RecipeRepository recipeRepository;

        public IngredientService(RecipeRepository recipeRepository) {
            this.recipeRepository = recipeRepository;
        }

        public Recipe save(Recipe recipe) {
            return recipeRepository.save(recipe);
        }

        public Recipe getById(Long id) throws Exception {
            Optional<Recipe> recipe = recipeRepository.findById(id);

            if (recipe.isEmpty()) {
                throw new Exception("Recipe não encontrado");
            }

            return recipe.get();
        }

        public List<Recipe> getAll() {
            return recipeRepository.findAll();
        }

        public void delete(Long id) {
            recipeRepository.deleteById(id);
        }

    }

}
