package com.example.swaggerexample.repository;

import com.example.swaggerexample.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    Integer deleteById(Long id);
    Event findEventById(Long id);
    List<Event> findEventsByTitle(String title);
}

