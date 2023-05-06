package com.example.personsservice.service;

import com.example.personsservice.domain.Person;
import com.example.personsservice.dto.PersonDto;
import com.example.personsservice.feign.NotesFeign;
import com.example.personsservice.repo.PersonRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;
    private final NotesFeign notesClient;
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public void save(final Person person) {
        personRepo.save(person);
    }

    public PersonDto getPersonByUsername(final String username) {
        final Person person = personRepo.getPersonByUserName(username);
        final List<String> notes = notesClient.getNotesList(username);
        return new PersonDto(person.getName(), notes);

//        final List<ServiceInstance> instances = discoveryClient.getInstances("notes");
//        final var notesInstance = instances.get(0);
//        final String notesURL = String.format(notesInstance.getUri()
//            + "/api/notes?username=%s", username);
//        final List<String> notes1 = (List<String>) restTemplate
//            .getForObject(notesURL, List.class);
//        final List<String> notes1 = (List<String>)circuitBreakerFactory.create("notes")
//            .run(() -> restTemplate
//                .getForObject(notesURL, List.class), throwable -> emptyList());

//        return new PersonDto(person.getName(), notes1);
    }

    private List<String> defaultEmptyList(){
        return emptyList();
    }
}
