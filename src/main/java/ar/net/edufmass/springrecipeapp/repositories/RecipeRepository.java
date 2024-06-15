package ar.net.edufmass.springrecipeapp.repositories;

import ar.net.edufmass.springrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
