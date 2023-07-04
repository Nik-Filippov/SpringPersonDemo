package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person p) {
        DB.add(new Person(id, p.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Person selectPersonByID(UUID id) {
        for(Person person : DB){
            if(person.getId().equals(id)){
                return person;
            }
        }
        return null;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        deletePerson(id);
        insertPerson(person.getId(), person);
        return 1;
    }

    @Override
    public int deletePerson(UUID id) {
        Person p = selectPersonByID(id);
        DB.remove(p);
        return 1;
    }
}
