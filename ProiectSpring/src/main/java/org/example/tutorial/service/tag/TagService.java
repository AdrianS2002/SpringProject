package org.example.tutorial.service.tag;

import org.example.tutorial.models.Tag;

import java.util.Optional;

public interface TagService {
    Tag save(Tag tag);
    Optional<Tag> findById(Integer id);
    Iterable<Tag> findAll();
    void deleteById(Integer id);

}
