package de.tekup.recipe.data.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.data.repositories.RecipeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

	private RecipeRepository reposRecipe;
	
	@Override
	public List<Recipe> getAllRecipes() {
		return reposRecipe.findAll();
	}

	@Override
	public Recipe getRecipeById(long id) {
		
		return reposRecipe.findById(id)
							.orElseThrow(()-> new NoSuchElementException("Recipe id not found"));
	}

	@Override
	public void deleteRecipeById(long id) {
		reposRecipe.deleteById(id);
		
	}

}
