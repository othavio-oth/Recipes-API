package com.palmirinha.ingredient.controller.dto;

import com.palmirinha.ingredient.model.Ingredient;

public class IngredientMapper {

	public static IngredientResponseDTO fromEntity(Ingredient ingredient) {
		return new IngredientResponseDTO(ingredient.getId(), ingredient.getName());
	}

	public static Ingredient fromDTO(IngredientFormDTO dto) {
		return new Ingredient(null, dto.getName());
	}

}
