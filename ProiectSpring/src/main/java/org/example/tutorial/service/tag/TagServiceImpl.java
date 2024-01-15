package org.example.tutorial.service.tag;

import lombok.RequiredArgsConstructor;
import org.example.tutorial.data.TagRepository;
import org.example.tutorial.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    @Autowired
    private final TagRepository tagRepository;
    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Optional<Tag> findById(Integer id) {
       return tagRepository.findById(id);
    }

    @Override
    public Iterable<Tag> findAll() {
      return   tagRepository.findAll();

    }

    @Override
    public void deleteById(Integer id) {
        tagRepository.deleteById(id);

    }
}
