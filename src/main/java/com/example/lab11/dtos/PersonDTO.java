package com.example.lab11.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private List<PersonDTO> friends;
    private List<PersonDTO> friendsOf;

}
