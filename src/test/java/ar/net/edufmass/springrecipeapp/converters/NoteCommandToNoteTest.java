package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.NoteCommand;
import ar.net.edufmass.springrecipeapp.domain.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteCommandToNoteTest {

    final Long note_id = 1L;
    final String recipe_note = "Notes";
    NoteCommandToNote noteCommandToNote;

    @BeforeEach
    public void setUp() throws Exception {
        noteCommandToNote = new NoteCommandToNote();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(noteCommandToNote.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(noteCommandToNote.convert(new NoteCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(note_id);
        noteCommand.setRecipeNote(recipe_note);

        //when
        Note note = noteCommandToNote.convert(noteCommand);

        //then
        assertNotNull(note);
        assertEquals(note_id, note.getId());
        assertEquals(recipe_note, note.getRecipeNote());
    }
}