package com.isthisalis.website.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isthisalis.website.dto.ProjectDTO;
import com.isthisalis.website.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectsService {
    
    private final ProjectRepository repository;


    public ProjectDTO getProject(int id) {
        return ProjectDTO.wrap(repository.findById(id).get());
    }

    public List<ProjectDTO> getProjects() {
        return repository.findAll().stream().map(ProjectDTO::wrap).toList();
    }
}
