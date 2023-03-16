package com.palmirinha.ingredient.config;

import com.palmirinha.ingredient.model.Ingredient;
import com.palmirinha.ingredient.service.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Bean
    public void startDB(){
        Ingredient ingredient1 = new Ingredient(null,"Egg");
        Ingredient ingredient2 = new Ingredient(null,"Milk");
        Ingredient ingredient3 = new Ingredient(null, "Salt");
        Ingredient ingredient4 = new Ingredient(null, "Chicken");

        ingredientRepository.saveAll(List.of(ingredient1,ingredient2,ingredient3,ingredient4));
    }
}
