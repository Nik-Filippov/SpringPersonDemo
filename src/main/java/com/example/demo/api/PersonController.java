package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person p){
        personService.addPerson(p);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonByID(@NotBlank @PathVariable("id") UUID id) {
        return personService.selectPersonByID(id);
    }
    @PutMapping(path = "{id}")
    public int updatePerson(@NotBlank @PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person p){
        return personService.updatePerson(id, p);
    }
    @DeleteMapping(path = "{id}")
    public int deletePerson(@NotBlank @PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }
}
