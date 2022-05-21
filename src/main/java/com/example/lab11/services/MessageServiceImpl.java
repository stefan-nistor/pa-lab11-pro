package com.example.lab11.services;

import com.example.lab11.dtos.MessageDTO;
import com.example.lab11.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    /**
     * Send a message to a person
     *
     * @param messageDTO {@link MessageDTO} which contains IDs of sender and receiver and the message
     */
    @Override
    public void send(MessageDTO messageDTO) {

    }

    /**
     * Read all messages received by a person with specified id
     *
     * @param id {@link Long} representing the ID of whom messages should be read
     * @return {@link List} of {@link MessageDTO} which contains IDs of sender and receiver and the message
     */
    @Override
    public List<MessageDTO> read(Long id) {
        return null;
    }
}
