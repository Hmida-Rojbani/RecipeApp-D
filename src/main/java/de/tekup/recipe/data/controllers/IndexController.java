package de.tekup.recipe.data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.recipe.data.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
	private RecipeService serviceRecipe;
	
	@GetMapping({"","/","/index"})
	public String getIndex(Model model) {
		model.addAttribute("recipes", serviceRecipe.getAllRecipes());
		return "index";
	}

}
