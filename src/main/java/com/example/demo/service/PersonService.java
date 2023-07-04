package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person p){
        return personDao.addPerson(p);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Person selectPersonByID(UUID id) {
        return personDao.selectPersonByID(id);
    }
    public int updatePerson(UUID id, Person p){
        return personDao.updatePerson(id, p);
    }

    public int deletePerson(UUID id){
        return personDao.deletePerson(id);
    }


}
