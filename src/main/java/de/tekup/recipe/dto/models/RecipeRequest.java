package de.tekup.recipe.dto.models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import de.tekup.recipe.data.entities.Difficulty;
import lombok.Data;

@Data
public class RecipeRequest {
	
	private Long id;
	@NotBlank
	@Size(min = 5, max = 50, message = "number of charcters must be in [5..50]")
	private String description;
	
	private LocalTime prepTime = LocalTime.of(0, 0);
	private String prepTimeTH;
	
	private LocalTime cookTime = LocalTime.of(0, 0);
	
	private String cookTimeTH;
	
	@Positive
	private Integer servings;
	
	private String directions;
	
	private Difficulty difficulty;
	

	
	public String getPrepTimeTH() {
		return prepTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public void setPrepTimeTH(String time) {
		prepTime = LocalTime.parse(time);
	}
	
	public String getCookTimeTH() {
		return cookTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public void setCookTimeTH(String time) {
		cookTime = LocalTime.parse(time);
	}

}
