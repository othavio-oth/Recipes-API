package com.palmirinha.ingredient.service;

import com.palmirinha.ingredient.model.Ingredient;
import com.palmirinha.ingredient.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {

	@Autowired
	private final IngredientRepository ingredientRepository;

	public Ingredient save(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	public Ingredient getById(Long id) throws ObjectNotFoundException {
		Optional<Ingredient> ingredient = ingredientRepository.findById(id);
		return ingredient.orElseThrow(() -> new ObjectNotFoundException("Ingredient not found"));
	}

	public List<Ingredient> getAll() {
		return ingredientRepository.findAll();
	}

	public void delete(Long id) {
		Ingredient ingredient = getById(id);
		ingredientRepository.delete(ingredient);
	}

}