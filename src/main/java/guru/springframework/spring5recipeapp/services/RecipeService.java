package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();
}
