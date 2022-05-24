package com.example.lab11.services;

import com.example.lab11.dtos.RelationshipDTO;
import com.example.lab11.entities.Relationship;
import com.example.lab11.exceptions.PersonNotFoundException;
import com.example.lab11.exceptions.RelationshipAlreadyExistsException;
import com.example.lab11.repos.PersonRepo;
import com.example.lab11.repos.RelationshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    RelationshipRepo relationshipRepo;

    @Autowired
    PersonRepo personRepo;

    /**
     * Get a list of all relationships
     *
     * @return {@link List} of {@link RelationshipDTO}
     */
    @Override
    public List<RelationshipDTO> getAllRelationships() {
        var relationships = relationshipRepo.findAll();
        List<RelationshipDTO> result = new LinkedList<>();
        relationships.forEach(relationship -> result.add(RelationshipDTO.builder()
                .id(relationship.getId())
                .person1(relationship.getPerson1().getName())
                .person2(relationship.getPerson2().getName())
                .build()));
        return result;
    }

    /**
     * Add a relationship between 2 persons
     *
     * @param relationshipDTO {@link RelationshipDTO} containing names of two persons
     */
    @Override
    public void addRelationship(RelationshipDTO relationshipDTO) {
        var relationship = relationshipRepo.findRelationshipByNames(relationshipDTO.getPerson1(), relationshipDTO.getPerson2());
        if (relationship.isPresent()) {
            throw new RelationshipAlreadyExistsException("Relationship already exists");
        }
        var person1 = personRepo.findByName(relationshipDTO.getPerson1());
        var person2 = personRepo.findByName(relationshipDTO.getPerson2());

        if (person1.isEmpty() || person2.isEmpty()) {
            throw new PersonNotFoundException("Not such person found.");
        }

        relationshipRepo.save(new Relationship().toBuilder()
                .person1(person1.get())
                .person2(person2.get())
                .build());

    }

}
