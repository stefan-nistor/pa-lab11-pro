package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;
import com.example.lab11.entities.Person;
import com.example.lab11.exceptions.PersonAlreadyExistsException;
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

    /**
     * Delete a person with given name
     *
     * @param name {@link String } representing person's name
     */
    @Override
    public void deletePersonByName(String name) {
        var entity = personRepo.findByName(name).orElseThrow(() -> new PersonNotFoundException("No such person for given name"));
        personRepo.delete(entity);
    }

    /**
     * Modify a person's name
     *
     * @param oldName {@link String} representing person's old name
     * @param newName {@link String} representing person's new name
     */
    @Override
    public void modifyPersonName(String oldName, String newName) {
        var entity = personRepo.findByName(oldName).orElseThrow(() -> new PersonNotFoundException("No such person for given name"));
        if (personRepo.findByName(newName).isPresent()) {
            throw new PersonAlreadyExistsException("There is already a person with this name");
        }
        entity.setName(newName);
        personRepo.save(entity);
    }

    /**
     * Add a person to database
     *
     * @param personDTO {@link PersonDTO} which contains person's name
     */
    @Override
    public void addPerson(PersonDTO personDTO) {
        var entity = personRepo.findByName(personDTO.getName());
        if (entity.isPresent()) {
            throw new PersonAlreadyExistsException("There is already a person with this name");
        }
        personRepo.save(mapper.map(personDTO, Person.class));
    }

    /**
     * Get a list of all persons
     *
     * @return {@link List} of {@link PersonDTO}
     */
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

    /**
     * Get a list of first K most popular persons
     *
     * @param count {@link Integer} representing size of the list
     * @return {@link List} of {@link PersonDTO} with first count most popular persons
     */
    @Override
    public List<PersonDTO> getKMostPopular(Integer count) {
        var entityList = personRepo.findMostPopular().stream().limit(count).collect(Collectors.toList());
        List<PersonDTO> result = new LinkedList<>();
        entityList.forEach(person -> result.add(mapper.map(person, PersonDTO.class)));
        return result;
    }
}
