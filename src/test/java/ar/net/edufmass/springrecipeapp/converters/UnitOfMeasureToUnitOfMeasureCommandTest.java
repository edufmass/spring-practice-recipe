package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.UnitOfMeasureCommand;
import ar.net.edufmass.springrecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    final String description = "description";
    final Long uom_id = 1L;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @BeforeEach
    public void setUp() throws Exception {
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(unitOfMeasureToUnitOfMeasureCommand.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(unitOfMeasureToUnitOfMeasureCommand.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uom_id);
        uom.setDescription(description);
        //when
        UnitOfMeasureCommand uomc = unitOfMeasureToUnitOfMeasureCommand.convert(uom);

        //then
        assertEquals(uom_id, uomc.getId());
        assertEquals(description, uomc.getDescription());
    }
}