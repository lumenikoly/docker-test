package com.example.swaggerexample.controller;

import com.example.swaggerexample.api.EventsApi;
import com.example.swaggerexample.models.EventModel;
import com.example.swaggerexample.models.EventRequest;
import com.example.swaggerexample.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class EventController implements EventsApi {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * POST /events : Add a new event to the events
     *
     * @param eventRequest Event object that needs to be added (required)
     * @return Created (status code 201)
     * or Invalid input (status code 405)
     */
    @Override
    public ResponseEntity<Void> addEvent(@Valid EventRequest eventRequest) {
        boolean isSaved = eventService.addEvent(eventRequest);
        return isSaved ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<Void> deleteEvent(Long eventId) {
        Integer numberDelete = eventService.deleteEvent(eventId);
        if (numberDelete.equals(1)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<EventModel> findEventsById(Long eventId) {
        return new ResponseEntity<>(eventService.findEventsById(eventId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EventModel>> findEventsByTitle(@NotNull @Valid String title) {
        return new ResponseEntity<>(eventService.findEventsByTitle(title), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EventModel>> getAllEvent() {
        return new ResponseEntity<>(eventService.getAllEvent(), HttpStatus.OK);
    }

}
