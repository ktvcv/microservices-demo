package com.example.notes.api;

import com.example.notes.domain.Note;
import com.example.notes.repo.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class NotesController {

    private final NotesRepository repository;

    @PostMapping(value = "/api/notes")
    public void saveNote(@RequestBody final Note note) {
        repository.save(note);
    }

    @GetMapping(value = "/api/notes")
    public Set<String> getNotes(@RequestParam final String username) {
       return repository.getUserNotes(username);
    }
}
