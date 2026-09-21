package com.isthisalis.website.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isthisalis.website.dto.CommentDTO;
import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.service.CommentService;
import com.isthisalis.website.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    
    private final CommentService commentService;
    private final PostService postService;

    @GetMapping("{id}/comments")
    public List<CommentDTO> getComments(@PathVariable int id) {
        return commentService.getComments(id);
    }

    @GetMapping
    public List<PostDTO> getPosts() {
        return postService.getAllPosts();
    }
}
