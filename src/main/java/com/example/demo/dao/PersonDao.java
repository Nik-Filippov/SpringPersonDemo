package com.example.demo.dao;

import com.example.demo.model.Person;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person p);

    default int addPerson(Person p){
        UUID id = UUID.randomUUID();
        return insertPerson(id, p);
    }

    List<Person> selectAllPeople();

    Person selectPersonByID(UUID id);

    int updatePerson(UUID id, Person p);

    int deletePerson(UUID id);
}
