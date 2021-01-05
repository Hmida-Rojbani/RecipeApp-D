package de.tekup.recipe.data.services;

import java.util.List;

import de.tekup.recipe.data.entities.Recipe;

public interface RecipeService {
	
	List<Recipe> getAllRecipes();
	Recipe getRecipeById(long id);
	void deleteRecipeById(long id);
	void saveOrUpdate(Recipe recipe);

}
