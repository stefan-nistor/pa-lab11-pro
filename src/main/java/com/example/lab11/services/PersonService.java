package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;

import java.util.List;

public interface PersonService {

    void deletePersonByName(String name);

    void modifyPersonName(String oldName, String newName);

    void addPerson(PersonDTO personDTO);

    List<PersonDTO> getAllPersons();

    List<PersonDTO> getKMostPopular(Integer count);

}
