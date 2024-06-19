package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.CategoryCommand;
import ar.net.edufmass.springrecipeapp.commands.IngredientCommand;
import ar.net.edufmass.springrecipeapp.commands.NotesCommand;
import ar.net.edufmass.springrecipeapp.commands.RecipeCommand;
import ar.net.edufmass.springrecipeapp.domain.Difficulty;
import ar.net.edufmass.springrecipeapp.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

    final Long recipe_id = 1L;
    final Integer cook_time = Integer.valueOf("5");
    final Integer prep_time = Integer.valueOf("7");
    final String description = "My Recipe";
    final String directions = "Directions";
    final Difficulty difficulty = Difficulty.EASY;
    final Integer servings = Integer.valueOf("3");
    final String source = "Source";
    final String url = "Some url";
    final Long category_id_1 = 1L;
    final Long category_id_2 = 2L;
    final Long ingredient_id_1 = 3L;
    final Long ingredient_id_2 = 4L;
    final Long note_id = 9L;

    RecipeCommandToRecipe recipeCommandToRecipe;


    @BeforeEach
    public void setUp() throws Exception {
        recipeCommandToRecipe = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(recipeCommandToRecipe.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(recipeCommandToRecipe.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe_id);
        recipeCommand.setCookTime(cook_time);
        recipeCommand.setPrepTime(prep_time);
        recipeCommand.setDescription(description);
        recipeCommand.setDifficulty(difficulty);
        recipeCommand.setDirections(directions);
        recipeCommand.setServings(servings);
        recipeCommand.setSource(source);
        recipeCommand.setUrl(url);

        NotesCommand notes = new NotesCommand();
        notes.setId(note_id);

        recipeCommand.setNotes(notes);

        CategoryCommand category = new CategoryCommand();
        category.setId(category_id_1);

        CategoryCommand category2 = new CategoryCommand();
        category2.setId(category_id_2);

        recipeCommand.getCategories().add(category);
        recipeCommand.getCategories().add(category2);

        IngredientCommand ingredient = new IngredientCommand();
        ingredient.setId(ingredient_id_1);

        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(ingredient_id_2);

        recipeCommand.getIngredients().add(ingredient);
        recipeCommand.getIngredients().add(ingredient2);

        //when
        Recipe recipe  = recipeCommandToRecipe.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(recipe_id, recipe.getId());
        assertEquals(cook_time, recipe.getCookTime());
        assertEquals(prep_time, recipe.getPrepTime());
        assertEquals(description, recipe.getDescription());
        assertEquals(difficulty, recipe.getDifficulty());
        assertEquals(directions, recipe.getDirections());
        assertEquals(servings, recipe.getServings());
        assertEquals(source, recipe.getSource());
        assertEquals(url, recipe.getUrl());
        assertEquals(note_id, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }
}