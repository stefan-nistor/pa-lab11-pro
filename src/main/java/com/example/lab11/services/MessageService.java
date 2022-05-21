package com.example.lab11.services;

import com.example.lab11.dtos.MessageDTO;

import java.util.List;

public interface MessageService {

    /**
     * Send a message to a person
     *
     * @param messageDTO {@link MessageDTO} which contains IDs of sender and receiver and the message
     */
    void send(MessageDTO messageDTO);

    /**
     * Read all messages received by a person
     *
     * @param id {@link Long} representing the ID of whom messages should be read
     * @return {@link List} of {@link MessageDTO} which contains IDs of sender and receiver and the message
     */
    List<MessageDTO> read(Long id);
}
