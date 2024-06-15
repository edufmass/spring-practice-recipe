package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.UnitOfMeasureCommand;
import ar.net.edufmass.springrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    final String description = "description";
    final Long uom_id = 1L;

    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    @BeforeEach
    public void setUp() throws Exception {
        unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(unitOfMeasureCommandToUnitOfMeasure.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(unitOfMeasureCommandToUnitOfMeasure.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(uom_id);
        command.setDescription(description);

        //when
        UnitOfMeasure uom = unitOfMeasureCommandToUnitOfMeasure.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(uom_id, uom.getId());
        assertEquals(description, uom.getDescription());

    }
}