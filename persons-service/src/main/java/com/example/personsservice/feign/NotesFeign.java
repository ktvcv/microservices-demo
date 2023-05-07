package com.example.personsservice.feign;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.util.Collections.emptyList;

@FeignClient(name = "notes")
public interface NotesFeign {

    @GetMapping("/api/notes")
    @CircuitBreaker(name = "notes", fallbackMethod = "defaultEmptyList")
//    @Bulkhead(name = "notes")
//    @Retry(name = "notes")
    List<String> getNotesList(@RequestParam final String username);

     default List<String> defaultEmptyList(final String username,final Exception ex){
        return emptyList();
    }
}
