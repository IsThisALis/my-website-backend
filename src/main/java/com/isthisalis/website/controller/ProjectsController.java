package com.isthisalis.website.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isthisalis.website.dto.ProjectDTO;
import com.isthisalis.website.service.ProjectsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectsController {
    
    private final ProjectsService service;

    @GetMapping("{id}")
    public ProjectDTO getProject(@PathVariable int id) {
        return service.getProject(id);
    }

    @GetMapping
    public List<ProjectDTO> getProjects() {
        return service.getProjects();
    }
}
