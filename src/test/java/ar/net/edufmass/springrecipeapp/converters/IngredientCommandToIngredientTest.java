package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.IngredientCommand;
import ar.net.edufmass.springrecipeapp.commands.UnitOfMeasureCommand;
import ar.net.edufmass.springrecipeapp.domain.Ingredient;
import ar.net.edufmass.springrecipeapp.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    final Recipe recipe = new Recipe();
    final BigDecimal amount = new BigDecimal("1");
    final String description = "Cheeseburger";
    final Long ingredient_id = 1L;
    final Long uom_id = 2L;

    IngredientCommandToIngredient ingredientCommandToIngredient;

    @BeforeEach
    public void setUp() throws Exception {
        ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(ingredientCommandToIngredient.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(ingredientCommandToIngredient.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ingredient_id);
        command.setAmount(amount);
        command.setDescription(description);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(uom_id);
        command.setUom(unitOfMeasureCommand);

        //when
        Ingredient ingredient = ingredientCommandToIngredient.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ingredient_id, ingredient.getId());
        assertEquals(amount, ingredient.getAmount());
        assertEquals(description, ingredient.getDescription());
        assertEquals(uom_id, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ingredient_id);
        command.setAmount(amount);
        command.setDescription(description);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();


        //when
        Ingredient ingredient = ingredientCommandToIngredient.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ingredient_id, ingredient.getId());
        assertEquals(amount, ingredient.getAmount());
        assertEquals(description, ingredient.getDescription());

    }
}