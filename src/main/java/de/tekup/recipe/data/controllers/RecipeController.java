package de.tekup.recipe.data.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.data.services.RecipeService;
import de.tekup.recipe.dto.models.RecipeRequest;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecipeController {
	
	private RecipeService serviceRecipe;
	private ModelMapper mapper;
	
	@GetMapping("/recipe/{recipeId}/show")
	public String getShowRecipe(Model model, @PathVariable("recipeId") long id) {
		model.addAttribute("recipe", serviceRecipe.getRecipeById(id));
		return "recipe/show";
	}
	
	@GetMapping("/recipe/{recipeId}/delete")
	public String deleteRecipe(@PathVariable("recipeId") long id) {
		serviceRecipe.deleteRecipeById(id);
		return "redirect:/"; 
	}
	
	@GetMapping("/recipe/{recipeId}/update")
	public String updateRecipe(Model model, @PathVariable("recipeId") long id) {
		// use recipeRequest (DTO) to support
		RecipeRequest request = mapper.map(serviceRecipe.getRecipeById(id), RecipeRequest.class);
		model.addAttribute("recipe", request);
		return "recipe/recipeform"; 
	}
	
	@PostMapping("/recipe")
	public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeRequest request,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			//display in console to check
			bindingResult.getAllErrors().forEach(System.err::println);
			return "recipe/recipeform";
		}
		Recipe recipe = mapper.map(request, Recipe.class);
		serviceRecipe.saveOrUpdate(recipe);
		return "redirect:/";
	}
	
	@GetMapping("/recipe/add")
	public String newRecipe(Model model) {
		// use recipeRequest (DTO) to support
		RecipeRequest request = new RecipeRequest();
		model.addAttribute("recipe", request);
		return "recipe/recipeform"; 
	}

}
