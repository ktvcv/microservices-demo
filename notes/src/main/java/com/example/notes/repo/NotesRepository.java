package com.example.notes.repo;

import com.example.notes.domain.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Repository
public class NotesRepository {

    private Map<String, List<Note>> notes = new HashMap<>();

    public void save(final Note note) {
        notes.computeIfAbsent(note.getUserName(), note1 -> new ArrayList<>()).add(note);
    }

    public List<String> getUserNotes(final String username) {
        return notes.get(username)
            .stream()
            .map(Note::getBody)
            .collect(toList());
    }
}
