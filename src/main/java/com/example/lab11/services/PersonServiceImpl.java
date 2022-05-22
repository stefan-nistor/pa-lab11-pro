package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;
import com.example.lab11.entities.Person;
import com.example.lab11.exceptions.PersonAlreadyExistsException;
import com.example.lab11.exceptions.PersonNotFoundException;
import com.example.lab11.repos.PersonRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void deletePersonByName(String name) {
        var entity = personRepo.findByName(name).orElseThrow(() -> new PersonNotFoundException("No such person for given name"));
        personRepo.delete(entity);
    }

    @Override
    public void modifyPersonName(String oldName, String newName) {
        var entity = personRepo.findByName(oldName).orElseThrow(() -> new PersonNotFoundException("No such person for given name"));
        entity.setName(newName);
        personRepo.save(entity);
    }

    @Override
    public void addPerson(PersonDTO personDTO) {
        var entity = personRepo.findByName(personDTO.getName());
        if (entity.isPresent()) {
            throw new PersonAlreadyExistsException("Person already exists");
        }
        personRepo.save(mapper.map(personDTO, Person.class));
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public List<Person> getKMostPopular(Integer count) {
        return personRepo.findMostPopular().stream().limit(count).collect(Collectors.toList());
    }
}
