package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public void deletePersonByName(String name) {

    }

    @Override
    public void modifyPersonName(String oldName, String newName) {

    }

    @Override
    public void addPerson(PersonDTO personDTO) {

    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return null;
    }
}
