package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.NotesCommand;
import ar.net.edufmass.springrecipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {

    final Long notes_id = 1L;
    final String recipe_notes = "Notes";
    NotesToNotesCommand noteToNotesCommand;

    @BeforeEach
    public void setUp() throws Exception {
        noteToNotesCommand = new NotesToNotesCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Notes notes = new Notes();
        notes.setId(notes_id);
        notes.setRecipeNotes(recipe_notes);

        //when
        NotesCommand notesCommand = noteToNotesCommand.convert(notes);

        //then
        assertEquals(notes_id, notesCommand.getId());
        assertEquals(recipe_notes, notesCommand.getRecipeNotes());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(noteToNotesCommand.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(noteToNotesCommand.convert(new Notes()));
    }
}