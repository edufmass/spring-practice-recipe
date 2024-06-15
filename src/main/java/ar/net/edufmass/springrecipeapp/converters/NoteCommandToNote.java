package ar.net.edufmass.springrecipeapp.converters;

import ar.net.edufmass.springrecipeapp.commands.NoteCommand;
import ar.net.edufmass.springrecipeapp.domain.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if(source == null) {
            return null;
        }

        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNote(source.getRecipeNote());
        return note;
    }
}
