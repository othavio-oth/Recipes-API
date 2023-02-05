package com.palmirinha.recipe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class IngredientRecipeFK implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne(fetch=FetchType.LAZY)
	private Recipe recipe;

    
	@ManyToOne(fetch=FetchType.LAZY)
  private Ingredient ingredient;
}
