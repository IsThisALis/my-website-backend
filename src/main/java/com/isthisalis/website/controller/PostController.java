package com.isthisalis.website.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isthisalis.website.dto.CommentDTO;
import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.entity.Post;

import com.isthisalis.website.service.CommentService;
import com.isthisalis.website.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    
    private final CommentService commentService;
    private final PostService postService;


    @GetMapping("/{id}/comments")
    public List<CommentDTO> getComments(@PathVariable int id) {
        return commentService.getComments(id);
    }


    @GetMapping
    public List<PostDTO> getPosts() {
        return postService.getAllPosts();
    }


    @DeleteMapping("/{id}/delete")
    public void deletePost(@PathVariable int id) {
        postService.delete(id);
    }


    @PatchMapping("/{id}/edit")
    public void editPost(@PathVariable int id, @Valid @RequestBody PostDTO postDTO) {
        postService.editPost(id, postDTO);
    }

    @PostMapping
    public void addPost(@Valid @RequestBody PostDTO post) {
        postService.addPost(Post.wrap(post));
    }
}
