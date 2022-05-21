package com.example.lab11.services;

import com.example.lab11.dtos.RelationshipDTO;

import java.util.List;

public interface RelationshipService {

    List<RelationshipDTO> getAllRelationships();

    void addRelationship(RelationshipDTO relationshipDTO);
}
