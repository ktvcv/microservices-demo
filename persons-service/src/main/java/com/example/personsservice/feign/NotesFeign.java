package com.example.personsservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "notes")
public interface NotesFeign {

    @GetMapping("/api/notes")
     List<String> getNotesList(@RequestParam final String username);
}
