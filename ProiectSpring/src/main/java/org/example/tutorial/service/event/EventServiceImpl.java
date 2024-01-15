package org.example.tutorial.service.event;

import lombok.RequiredArgsConstructor;
import org.example.tutorial.data.EventRepository;
import org.example.tutorial.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements  EventService{

    @Autowired
   private final EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Integer id) {
        return eventRepository.findById(id);
    }


    @Override
    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        eventRepository.deleteById(id);

    }
}
