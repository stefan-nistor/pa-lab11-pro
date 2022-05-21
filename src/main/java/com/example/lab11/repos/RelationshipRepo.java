package com.example.lab11.repos;

import com.example.lab11.entities.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelationshipRepo extends JpaRepository<Relationship, Long> {

    @Query("SELECT r FROM Relationship r WHERE r.person1.name = ?1 and r.person2.name = ?2")
    Optional<Relationship> findRelationshipByNames(String person1, String person2);
}
