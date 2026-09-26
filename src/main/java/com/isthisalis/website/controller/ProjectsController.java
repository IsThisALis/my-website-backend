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

import com.isthisalis.website.dto.ProjectDTO;
import com.isthisalis.website.service.ProjectsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectsController {
    
    private final ProjectsService service;

    @GetMapping("/{id}")
    public ProjectDTO getProject(@PathVariable long id) {
        return service.getProject(id);
    }

    @GetMapping
    public List<ProjectDTO> getProjects() {
        return service.getProjects();
    }

    @PatchMapping("/{id}")
    public void editProject(@PathVariable long id, @Valid @RequestBody ProjectDTO projectDTO) {
        service.editProject(id, projectDTO);
    }

    @DeleteMapping
    public void deleteProjects() {
        service.deleteProjects();
    }

    @DeleteMapping("/{id}")
    public void deleteProjects(@PathVariable long id) {
        service.deleteProject(id);
    }

    @PostMapping
    public void createProject(@Valid @RequestBody ProjectDTO projectDTO) {
        service.createProject(projectDTO);
    }
}
