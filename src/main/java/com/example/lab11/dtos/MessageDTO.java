package com.example.lab11.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    Long id;
    Long fromId;
    Long toId;
    String message;
}
