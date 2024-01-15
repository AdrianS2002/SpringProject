package org.example.tutorial.service.eventCategory;

import lombok.RequiredArgsConstructor;
import org.example.tutorial.data.EventCategoryRepository;
import org.example.tutorial.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.tutorial.models.EventCategory;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventCategoryImpl implements EventCategoryService{

    @Autowired  //dependecy injection
    private final EventCategoryRepository eventCategoryRepository;


    @Override
    public EventCategory save(EventCategory eventCategory) {
        return eventCategoryRepository.save(eventCategory);
    }

    @Override
    public Optional<EventCategory> findById(Integer id) {
        return eventCategoryRepository.findById(id);
    }

    @Override
    public Iterable<EventCategory> findAll() {
        return eventCategoryRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        eventCategoryRepository.deleteById(id);
    }
}
