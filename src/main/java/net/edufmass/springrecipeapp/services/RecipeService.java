package net.edufmass.springrecipeapp.services;

import net.edufmass.springrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
