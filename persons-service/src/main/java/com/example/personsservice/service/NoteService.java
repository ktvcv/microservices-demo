package com.example.personsservice.service;

import com.example.personsservice.feign.NotesFeign;
import com.example.personsservice.repo.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NotesFeign notesClient;
    private final NoteRepo noteRepo;

    //when received notes-added-event
    public void synchronizePersonNotes(final String username) {
        final List<String> notes = notesClient.getNotesList(username);

        noteRepo.save(username, notes);
    }
}
