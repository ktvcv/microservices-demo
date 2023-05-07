package com.example.personsservice.config;

import com.example.personsservice.event.NoteAddedEvent;
import com.example.personsservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    private final NoteService noteService;

    @Bean
    public Consumer<NoteAddedEvent> noteAddedEventConsumer() {
        return event -> {
            log.info("Received event : " + event.username());
            noteService.synchronizePersonNotes(event.username());
        };
    }
}
