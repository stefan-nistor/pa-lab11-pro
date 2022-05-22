package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;
import com.example.lab11.entities.Person;
import com.example.lab11.exceptions.PersonNotFoundException;
import com.example.lab11.repos.PersonRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    ModelMapper mapper;

    //TODO : delete relationship if exits with given user
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
        var entity = personRepo.findByName(personDTO.getName()).orElseThrow(() -> new PersonNotFoundException("No such person for given name"));
        personRepo.save(mapper.map(personDTO, Person.class));
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        var entityList = personRepo.findAll();
        List<PersonDTO> result = new LinkedList<>();
        entityList.forEach(person -> result.add(PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .build()));
        return result;
    }

    @Override
    public List<PersonDTO> getKMostPopular(Integer count) {
        var entityList = personRepo.findMostPopular().stream().limit(count).collect(Collectors.toList());
        List<PersonDTO> result = new LinkedList<>();
        entityList.forEach(person -> result.add(mapper.map(person, PersonDTO.class)));
        return result;
    }
}
