package com.isthisalis.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.dto.TagDTO;
import com.isthisalis.website.entity.Post;
import com.isthisalis.website.entity.Tag;
import com.isthisalis.website.repository.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {
    
    private final TagRepository repository;

    public TagDTO getTag(String name) {
        Tag tag = repository.findByName(name)
            .orElseThrow(()-> 
                new ResponseStatusException(HttpStatusCode.valueOf(404))
        );
        return TagDTO.wrap(tag);
    }

    public TagDTO getTag(long id) {
        Tag tag = repository.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatusCode.valueOf(404))
        );

        return TagDTO.wrap(tag);
    }

    public List<TagDTO> getAllTags() {
        return repository.findAll()
            .stream()
            .map(TagDTO::wrap)
            .toList();
    }

    public void addTag(TagDTO tagDTO) {
        repository.save(Tag.wrap(tagDTO));
    }

    public void editTag(TagDTO tagDTO, String name) {
        Tag tag = repository.findByName(name)
            .orElseThrow(() -> 
                new ResponseStatusException(HttpStatusCode.valueOf(404))
        );

        tag.setName(tagDTO.getName());
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

    public List<PostDTO> getPostsByTag(String tagName) {
        Tag tag = repository.findByName(tagName)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404))
        );

        List<PostDTO> posts = new ArrayList<>();

        for (Post post : tag.getPosts()) {
            posts.add(PostDTO.wrap(post));
        }

        return posts;
    }
}
