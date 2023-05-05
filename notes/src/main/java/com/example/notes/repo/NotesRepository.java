package com.example.notes.repo;

import com.example.notes.domain.Note;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Repository
public class NotesRepository {

    private Set<Note> notes = new HashSet<>();

    public void save(final Note note) {
        notes.add(note);
    }

    public Set<String> getUserNotes(final String username) {
        return notes
            .stream()
            .filter(note -> Objects.equals(username, note.getUserName()))
            .map(Note::getBody)
            .collect(toSet());
    }
}
