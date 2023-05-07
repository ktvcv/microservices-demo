package com.example.personsservice.repo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoteRepo {

    private final Map<String, List<String>> notes = new HashMap<>();

    public void save(final String username, final List<String> notesToAdd) {
        notes.put(username, notesToAdd);
    }

    public List<String> getUserNotes(final String username) {
        return notes.get(username);
    }
}
