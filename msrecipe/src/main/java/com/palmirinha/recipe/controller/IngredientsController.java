package com.palmirinha.recipe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palmirinha.recipe.controller.dto.IngredientFormDTO;
import com.palmirinha.recipe.controller.dto.IngredientMapper;
import com.palmirinha.recipe.controller.dto.IngredientResponseDTO;
import com.palmirinha.recipe.model.Ingredient;
import com.palmirinha.recipe.service.IngredientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/ingredients")
@RequiredArgsConstructor
public class IngredientsController {

	@Autowired
	private  final IngredientService ingredientService;

	@GetMapping("{id}")
	public ResponseEntity<IngredientResponseDTO> getIngredient(@PathVariable Long id) {

		Ingredient ingredient;
		try {
			ingredient = ingredientService.getById(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(IngredientMapper.fromEntity(ingredient));
	}

	@PostMapping
	public ResponseEntity<IngredientResponseDTO> saveIngredient(@RequestBody IngredientFormDTO dto) {

		Ingredient ingredient = ingredientService.save(IngredientMapper.fromDTO(dto));
		return ResponseEntity.ok(IngredientMapper.fromEntity(ingredient));

	}

	@GetMapping
	public ResponseEntity<List<IngredientResponseDTO>> getAllIngredients(){
		List<Ingredient> ingredients = ingredientService.getAll();
		List<IngredientResponseDTO> ingredientsDto = ingredients.stream()
		.map(IngredientMapper::fromEntity).collect(Collectors.toList());
		return ResponseEntity.ok(ingredientsDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<IngredientResponseDTO> deleteIngredient(@PathVariable Long id){
		ingredientService.delete(id);
		return ResponseEntity.ok().build();
	}
}

