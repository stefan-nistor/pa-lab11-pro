package com.example.lab11.controllers;

import com.example.lab11.dtos.MessageDTO;
import com.example.lab11.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.send(messageDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping ResponseEntity<?> readMessages(@RequestParam Long id) {
        return ResponseEntity.ok().body(messageService.read(id));
    }

}
