package com.example.lab11.services;

import com.example.lab11.dtos.RelationshipDTO;

import java.util.List;

public interface RelationshipService {

    /**
     * Get a list of all relationships
     *
     * @return {@link List} of {@link RelationshipDTO}
     */
    List<RelationshipDTO> getAllRelationships();

    /**
     * Add a relationship between 2 persons
     *
     * @param relationshipDTO {@link RelationshipDTO} containing names of two persons
     */
    void addRelationship(RelationshipDTO relationshipDTO);
}
