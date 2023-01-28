package com.palmirinha.recipe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_ingredient_recipe")
public class IngredientRecipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name = "fk_ingredientId")
	private Ingredient ingredient;
	
	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name = "fk_unitId")
	private UnitOfMeasurement unitOfMeasurement;
	
	 @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="fk_recipeId")
	private Recipe recipe;
	
	private String amount;
	
	

}
