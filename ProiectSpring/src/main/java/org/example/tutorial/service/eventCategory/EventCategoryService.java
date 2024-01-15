package org.example.tutorial.service.eventCategory;

import org.example.tutorial.models.EventCategory;
import org.example.tutorial.service.event.EventService;

import java.util.Optional;

public interface EventCategoryService {
 EventCategory save(EventCategory eventCategory);
 Optional<EventCategory> findById(Integer id);
    Iterable<EventCategory> findAll();
    void deleteById(Integer id);

}
