package de.tekup.recipe.data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.recipe.data.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecipeController {
	
	private RecipeService serviceRecipe;
	
	@GetMapping("/recipe/{recipeId}/show")
	public String getShowRecipe(Model model, @PathVariable("recipeId") long id) {
		model.addAttribute("recipe", serviceRecipe.getRecipeById(id));
		return "recipe/show";
	}

}
