package com.example.lab11.controllers;

import com.example.lab11.dtos.MessageDTO;
import com.example.lab11.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    /**
     * Send a message to a person
     *
     * @param messageDTO {@link MessageDTO} which contains IDs of sender and receiver and the message
     * @return 204 - No content if message was sent successfully, 404 - Not Found if sender or receiver was not found in database
     */
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.send(messageDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Read all messages received by a person with specified id
     *
     * @param id {@link Long} representing the ID of whom messages should be read
     * @return 404 - Not found if given id was not found in database, 200 - Ok and a {@link List} of {@link MessageDTO} otherwise
     */
    @GetMapping
    ResponseEntity<?> readMessages(@RequestParam Long id) {
        return ResponseEntity.ok().body(messageService.read(id));
    }

}
