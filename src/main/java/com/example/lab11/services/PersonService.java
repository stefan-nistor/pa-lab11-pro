package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;
import com.example.lab11.entities.Person;

import java.util.List;

public interface PersonService {

    void deletePersonByName(String name);

    void modifyPersonName(String oldName, String newName);

    void addPerson(PersonDTO personDTO);

    List<Person> getAllPersons();

    List<Person> getKMostPopular(Integer count);

}
