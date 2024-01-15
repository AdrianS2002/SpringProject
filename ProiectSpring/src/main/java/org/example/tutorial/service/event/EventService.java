package org.example.tutorial.service.event;

import org.example.tutorial.models.Event;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event save(Event event);
    Optional<Event> findById(Integer id);
    Iterable<Event> findAll();
    void deleteById(Integer id);

}
