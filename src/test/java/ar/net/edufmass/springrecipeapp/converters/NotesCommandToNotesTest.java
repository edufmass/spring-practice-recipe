package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.NotesCommand;
import ar.net.edufmass.springrecipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    final Long notes_id = 1L;
    final String recipe_notes = "Notes";
    NotesCommandToNotes notesCommandToNotes;

    @BeforeEach
    public void setUp() throws Exception {
        notesCommandToNotes = new NotesCommandToNotes();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(notesCommandToNotes.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(notesCommandToNotes.convert(new NotesCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes_id);
        notesCommand.setRecipeNotes(recipe_notes);

        //when
        Notes notes = notesCommandToNotes.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(notes_id, notes.getId());
        assertEquals(recipe_notes, notes.getRecipeNotes());
    }
}