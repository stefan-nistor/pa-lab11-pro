package com.example.lab11.controllers;

import com.example.lab11.dtos.PersonDTO;
import com.example.lab11.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<?> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PostMapping
    public ResponseEntity<?> addPerson(@RequestBody PersonDTO personDTO){
        personService.addPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deletePerson(@RequestParam String name){
        personService.deletePersonByName(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<?> modifyPerson(@RequestParam String oldName, @RequestParam String newName){
        personService.modifyPersonName(oldName, newName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping(name = "/popularity}")
    public ResponseEntity<?> getFirstMostPopular(@RequestParam Integer count) {
        return ResponseEntity.ok(personService.getKMostPopular(count));
    }

}
