package es.albertopeam.apparchitecturelibs.domain;

import es.albertopeam.apparchitecturelibs.infrastructure.UseCase;

/**
 * Created by Al on 22/05/2017.
 */

public class AddNoteUseCase
        implements UseCase<String, String> {


    private NotesRepository repository;


    AddNoteUseCase(NotesRepository repository) {
        this.repository = repository;
    }


    @Override
    public String run(String note) throws Exception {
        if (note.equalsIgnoreCase("")){
            throw new NullPointerException("Note cannot be empty");
        }
        repository.addNote(note);
        return note;
    }
}