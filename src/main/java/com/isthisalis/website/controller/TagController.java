package com.isthisalis.website.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.dto.TagDTO;
import com.isthisalis.website.service.TagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    
    private final TagService service;


    @PostMapping
    public void createTag(@Valid @RequestBody TagDTO tagDTO) {
        service.addTag(tagDTO);
    }


    @GetMapping
    public List<TagDTO> getTags() {
        return service.getAllTags();
    }

    @GetMapping("/{name}/posts")
    public List<PostDTO> getPostsByTag(@PathVariable String name) {
        return service.getPostsByTag(name);
    }

    @DeleteMapping("/{name}")
    public void deleteTag(@PathVariable String name) {
        service.deleteTag(name);
    }
}
