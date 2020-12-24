package com.example.swaggerexample.mapper;

import com.example.swaggerexample.entities.Category;
import com.example.swaggerexample.entities.Event;
import com.example.swaggerexample.models.CategoryModel;
import com.example.swaggerexample.models.EventModel;
import com.example.swaggerexample.models.EventRequest;

import java.util.List;
import java.util.stream.Collectors;

public class EventMapper {

    public static Event toEntity(EventRequest eventRequest, Category category) {
        return new Event(eventRequest.getTitle(), eventRequest.getPrice(),
                category, eventRequest.getDate(), eventRequest.getDescription());
    }

    public static EventModel toApi(Event event) {
        CategoryModel category = CategoryMapper.toApi(event.getCategory());
        EventModel eventModel = new EventModel();
        eventModel.setId(event.getId());
        eventModel.setTitle(event.getTitle());
        eventModel.setPrice(event.getPrice());
        eventModel.setCategory(category);
        eventModel.setDate(event.getDate());
        eventModel.setDescription(event.getDescription());

        return eventModel;
    }

    public static List<EventModel> toApi(List<Event> categoryList) {
        return categoryList.stream()
                .map(EventMapper::toApi)
                .collect(Collectors.toList());
    }
}
