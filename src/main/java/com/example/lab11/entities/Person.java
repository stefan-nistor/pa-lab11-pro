package com.example.lab11.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relationship> friends = new LinkedList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relationship> friendsOf = new LinkedList<>();

}
