package com.palmirinha.recipe.model;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_ingredient_recipe")
public class IngredientRecipe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngredientRecipeFK ingredientRecipeFK;
	
	@ManyToOne
	private UnitOfMeasurement unitOfMeasurement;
	
	private String amount;
	
	

}
