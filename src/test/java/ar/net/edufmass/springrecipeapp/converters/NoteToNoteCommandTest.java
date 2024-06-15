package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.NoteCommand;
import ar.net.edufmass.springrecipeapp.domain.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteToNoteCommandTest {

    final Long note_id = 1L;
    final String recipe_note = "Notes";
    NoteToNoteCommand noteToNoteCommand;

    @BeforeEach
    public void setUp() throws Exception {
        noteToNoteCommand = new NoteToNoteCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note note = new Note();
        note.setId(note_id);
        note.setRecipeNote(recipe_note);

        //when
        NoteCommand noteCommand = noteToNoteCommand.convert(note);

        //then
        assertEquals(note_id, noteCommand.getId());
        assertEquals(recipe_note, noteCommand.getRecipeNote());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(noteToNoteCommand.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(noteToNoteCommand.convert(new Note()));
    }
}