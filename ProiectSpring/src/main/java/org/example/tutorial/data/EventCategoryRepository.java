package org.example.tutorial.data;

import org.example.tutorial.models.Event;
import org.example.tutorial.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory,Integer> {
}
