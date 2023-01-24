package com.palmirinha.msingredients.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmirinha.msingredients.model.Ingredient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientService {
	
	@Autowired
	private final IngredientRepository ingredientRepository;
	
	public Ingredient save(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}
	
	public Ingredient getById(Long id) throws Exception {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		
		if(ingredient.isEmpty()) {
			throw new Exception("Ingrediente não encontrado");
		}
		
		return ingredient.get();
	}
	
	public List<Ingredient> getAll(){
		return ingredientRepository.findAll();
	}
	
	
	public void delete(Long id) {
		ingredientRepository.deleteById(id);
	}

}