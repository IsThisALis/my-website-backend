package com.isthisalis.website.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.isthisalis.website.dto.TagDTO;
import com.isthisalis.website.entity.Tag;
import com.isthisalis.website.repository.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {
    
    private final TagRepository repository;

    public TagDTO getTag(String name) {
        return TagDTO.wrap(repository.findByName(name));
    }

    public TagDTO getTag(long id) {
        Tag tag = repository.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatusCode.valueOf(404))
        );

        return TagDTO.wrap(tag);
    }

    public void addTag(TagDTO tagDTO) {
        repository.save(Tag.wrap(tagDTO));
    }

    public void editTag(TagDTO tagDTO, String tagName) {
        repository.findByName(tagName).setName(tagDTO.getName());
    }


    public void editTag(TagDTO tagDTO, long id) {
        Tag tag = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        tag.setName(tagDTO.getName());
    }


    public void deleteTag(String name) {
        repository.deleteByName(name);
    }

    public void deleteTag(long id) {
        repository.deleteById(id);
    }
}
