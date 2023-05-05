package com.example.personsservice.api;

import com.example.personsservice.domain.Person;
import com.example.personsservice.dto.PersonDto;
import com.example.personsservice.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/api/person")
    public void save(@RequestBody final Person person){
        personService.save(person);
    }

    @GetMapping(value = "/api/person/with-notes")
    public PersonDto getPersonWithNotes(@RequestParam final String username){
        return personService.getPersonByUsername(username);
    }
}
