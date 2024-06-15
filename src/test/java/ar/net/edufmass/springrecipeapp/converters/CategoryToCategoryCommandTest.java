package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.CategoryCommand;
import ar.net.edufmass.springrecipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    final Long category_id = 1L;
    final String description = "description";
    CategoryToCategoryCommand categoryToCategoryCommand;

    @BeforeEach
    public void setUp() throws Exception {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(category_id);
        category.setDescription(description);

        //when
        CategoryCommand categoryCommand = categoryToCategoryCommand.convert(category);

        //then
        assertEquals(category_id, categoryCommand.getId());
        assertEquals(description, categoryCommand.getDescription());

    }
}