package com.palmirinha.ingredient.controller;

import com.palmirinha.ingredient.controller.dto.IngredientFormDTO;
import com.palmirinha.ingredient.controller.dto.IngredientMapper;
import com.palmirinha.ingredient.controller.dto.IngredientResponseDTO;
import com.palmirinha.ingredient.model.Ingredient;
import com.palmirinha.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/ingredients")
@RequiredArgsConstructor
public class IngredientsController {

	@Autowired
	private final IngredientService ingredientService;

	@GetMapping("{id}")
	public ResponseEntity<IngredientResponseDTO> getIngredient(@PathVariable Long id) {

		Ingredient ingredient;
		ingredient = ingredientService.getById(id);
		return ResponseEntity.ok(IngredientMapper.fromEntity(ingredient));
	}

	@PostMapping
	public ResponseEntity<IngredientResponseDTO> saveIngredient(@RequestBody IngredientFormDTO dto) {

		Ingredient ingredient = ingredientService.save(IngredientMapper.fromDTO(dto));
		return ResponseEntity.ok(IngredientMapper.fromEntity(ingredient));

	}

	@GetMapping
	public ResponseEntity<List<IngredientResponseDTO>> getAllIngredients() {
		List<Ingredient> ingredients = ingredientService.getAll();
		List<IngredientResponseDTO> ingredientsDto = ingredients.stream()
				.map(IngredientMapper::fromEntity).collect(Collectors.toList());
		return ResponseEntity.ok(ingredientsDto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<IngredientResponseDTO> deleteIngredient(@PathVariable Long id) {
		ingredientService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
