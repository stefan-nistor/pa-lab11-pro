package com.example.lab11.services;

import com.example.lab11.dtos.PersonDTO;

import java.util.List;

public interface PersonService {

    /**
     * Delete a person with given name
     *
     * @param name {@link String } representing person's name
     */
    void deletePersonByName(String name);

    /**
     * Modify a person's name
     *
     * @param oldName {@link String} representing person's old name
     * @param newName {@link String} representing person's new name
     */
    void modifyPersonName(String oldName, String newName);

    /**
     * Add a person to database
     *
     * @param personDTO {@link PersonDTO} which contains person's name
     */
    void addPerson(PersonDTO personDTO);

    /**
     * Get a list of all persons
     *
     * @return {@link List} of {@link PersonDTO}
     */
    List<PersonDTO> getAllPersons();

    /**
     * Get a list of first K most popular persons
     *
     * @param count {@link Integer} representing size of the list
     * @return {@link List} of {@link PersonDTO} with first count most popular persons
     */
    List<PersonDTO> getKMostPopular(Integer count);

}
