package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.CategoryCommand;
import ar.net.edufmass.springrecipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    final Long category_id = 1L;
    final String description = "description";
    CategoryCommandToCategory categoryCommandToCategory;

    @BeforeEach
    public void setUp() throws Exception {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(categoryCommandToCategory.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(categoryCommandToCategory.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(category_id);
        categoryCommand.setDescription(description);

        //when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        //then
        assertEquals(category_id, category.getId());
        assertEquals(description, category.getDescription());
    }
}