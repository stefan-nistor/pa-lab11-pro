package com.example.lab11.services;

import com.example.lab11.dtos.MessageDTO;

import java.util.List;

public interface MessageService {
    void send(MessageDTO messageDTO);
    List<MessageDTO> read(Long person);
}
