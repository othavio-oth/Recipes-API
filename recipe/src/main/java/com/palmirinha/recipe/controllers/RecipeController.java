package com.palmirinha.recipe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/recipes")
public class RecipeController {

    @GetMapping
    public String getOk() {
        return "ok";
    }
}
