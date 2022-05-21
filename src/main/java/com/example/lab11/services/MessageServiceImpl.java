package com.example.lab11.services;

import com.example.lab11.dtos.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{


    @Override
    public void send(MessageDTO messageDTO) {

    }

    @Override
    public List<MessageDTO> read(Long person) {
        return null;
    }
}
