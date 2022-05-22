package com.example.lab11.controllers;

import com.example.lab11.dtos.RelationshipDTO;
import com.example.lab11.services.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RelationshipController {

    @Autowired
    RelationshipService relationshipService;

    @GetMapping("/relationships")
    public ResponseEntity<?> getAllRelationships(){
        return ResponseEntity.ok(relationshipService.getAllRelationships());
    }

    @PostMapping("/relationships")
    public ResponseEntity<?> addRelationship(@RequestBody RelationshipDTO relationshipDTO) {
        relationshipService.addRelationship(relationshipDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
