package com.example.swaggerexample.service;

import com.example.swaggerexample.entities.Category;
import com.example.swaggerexample.mapper.EventMapper;
import com.example.swaggerexample.models.EventModel;
import com.example.swaggerexample.models.EventRequest;
import com.example.swaggerexample.repository.CategoryRepository;
import com.example.swaggerexample.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public EventService(EventRepository eventRepository, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public boolean addEvent(@Valid EventRequest eventRequest) {
        Optional<Category> category = categoryRepository.findById(eventRequest.getCategoryId());
        if (category.isPresent()) {
            eventRepository.save(EventMapper.toEntity(eventRequest, category.get()));
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Integer deleteEvent(Long eventId) {
        return eventRepository.deleteById(eventId);
    }

    public EventModel findEventsById(Long eventId) {
        return EventMapper.toApi(
                eventRepository.findEventById(eventId));
    }

    public List<EventModel> findEventsByTitle(@NotNull @Valid String title) {
        return EventMapper.toApi(eventRepository.findEventsByTitle(title));
    }

    public List<EventModel> getAllEvent() {
        return EventMapper.toApi(eventRepository.findAll());
    }

}
