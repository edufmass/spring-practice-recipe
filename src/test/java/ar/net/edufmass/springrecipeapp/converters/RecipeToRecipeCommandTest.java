package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.RecipeCommand;
import ar.net.edufmass.springrecipeapp.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {

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
    final Long notes_id = 9L;

    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    public void setUp() throws Exception {
        recipeToRecipeCommand = new RecipeToRecipeCommand(
                new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(recipeToRecipeCommand.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(recipeToRecipeCommand.convert(new Recipe()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(recipe_id);
        recipe.setCookTime(cook_time);
        recipe.setPrepTime(prep_time);
        recipe.setDescription(description);
        recipe.setDifficulty(difficulty);
        recipe.setDirections(directions);
        recipe.setServings(servings);
        recipe.setSource(source);
        recipe.setUrl(url);

        Notes notes = new Notes();
        notes.setId(notes_id);

        recipe.setNotes(notes);

        Category category = new Category();
        category.setId(category_id_1);

        Category category2 = new Category();
        category2.setId(category_id_2);

        recipe.getCategories().add(category);
        recipe.getCategories().add(category2);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredient_id_1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(ingredient_id_2);

        recipe.getIngredients().add(ingredient);
        recipe.getIngredients().add(ingredient2);

        //when
        RecipeCommand command = recipeToRecipeCommand.convert(recipe);

        //then
        assertNotNull(command);
        assertEquals(recipe_id, command.getId());
        assertEquals(cook_time, command.getCookTime());
        assertEquals(prep_time, command.getPrepTime());
        assertEquals(description, command.getDescription());
        assertEquals(difficulty, command.getDifficulty());
        assertEquals(directions, command.getDirections());
        assertEquals(servings, command.getServings());
        assertEquals(source, command.getSource());
        assertEquals(url, command.getUrl());
        assertEquals(notes_id, command.getNotes().getId());
        assertEquals(2, command.getCategories().size());
        assertEquals(2, command.getIngredients().size());

    }
}