package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
