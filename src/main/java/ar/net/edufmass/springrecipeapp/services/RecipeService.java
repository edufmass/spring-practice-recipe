package ar.net.edufmass.springrecipeapp.services;

import ar.net.edufmass.springrecipeapp.commands.RecipeCommand;
import ar.net.edufmass.springrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}
