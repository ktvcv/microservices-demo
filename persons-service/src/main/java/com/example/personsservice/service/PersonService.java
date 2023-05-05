package com.example.personsservice.service;

import com.example.personsservice.domain.Person;
import com.example.personsservice.dto.PersonDto;
import com.example.personsservice.feign.NotesFeign;
import com.example.personsservice.repo.PersonRepo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;
    private final NotesFeign notesClient;
//    private final DiscoveryClient discoveryClient;
//    private final RestTemplate restTemplate;

    public void save(final Person person){
        personRepo.save(person);
    }

    public PersonDto getPersonByUsername(final String username){
        final Person person = personRepo.getPersonByUserName(username);
        final List<String> notes = notesClient.getNotesList(username);
 //       final  List<InstanceInfo>  instances = discoveryClient.getInstancesById("notes");
 //       final var notesInstance = instances.get(0);
//        restTemplate
//            .getForEntity(notesInstance.getIPAddr(), String.class);


        return new PersonDto(person.getName(), notes);
    }
}
