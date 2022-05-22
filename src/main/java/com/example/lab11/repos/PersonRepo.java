package com.example.lab11.repos;

import com.example.lab11.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);

    @Query(value = "SELECT p FROM Person p ORDER BY p.friends.size DESC")
    List<Person> findMostPopular();
}
