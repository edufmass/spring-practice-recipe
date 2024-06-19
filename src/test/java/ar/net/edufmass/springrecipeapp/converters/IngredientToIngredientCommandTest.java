package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.IngredientCommand;
import ar.net.edufmass.springrecipeapp.domain.Ingredient;
import ar.net.edufmass.springrecipeapp.domain.Recipe;
import ar.net.edufmass.springrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    final Recipe recipe = new Recipe();
    final BigDecimal amount = new BigDecimal("1");
    final String description = "Cheeseburger";
    final Long ingredient_id = 1L;
    final Long uom_id = 2L;

    IngredientToIngredientCommand ingredientToIngredientCommand;

    @BeforeEach
    public void setUp() throws Exception {
        ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(ingredientToIngredientCommand.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(ingredientToIngredientCommand.convert(new Ingredient()));
    }

    @Test
    public void testConvertNullUOM() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredient_id);
        ingredient.setRecipe(recipe);
        ingredient.setAmount(amount);
        ingredient.setDescription(description);
        ingredient.setUom(null);
        //when
        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);
        //then
        assertNull(ingredientCommand.getUom());
        assertEquals(ingredient_id, ingredientCommand.getId());
        assertEquals(amount, ingredientCommand.getAmount());
        assertEquals(description, ingredientCommand.getDescription());
    }

    @Test
    public void testConvertWithUom() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredient_id);
        ingredient.setRecipe(recipe);
        ingredient.setAmount(amount);
        ingredient.setDescription(description);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uom_id);

        ingredient.setUom(uom);
        //when
        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);
        //then
        assertEquals(ingredient_id, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUom());
        assertEquals(uom_id, ingredientCommand.getUom().getId());
        assertEquals(amount, ingredientCommand.getAmount());
        assertEquals(description, ingredientCommand.getDescription());
    }
}