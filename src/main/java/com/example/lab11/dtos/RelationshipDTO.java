package com.example.lab11.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationshipDTO {

    private Long id;
    private String person1;
    private String person2;

}
