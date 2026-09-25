package com.isthisalis.website.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.isthisalis.website.dto.ProjectDTO;
import com.isthisalis.website.entity.Project;
import com.isthisalis.website.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectsService {
    
    private final ProjectRepository repository;


    public ProjectDTO getProject(long id) {
        return ProjectDTO.wrap(repository.findById(id).get());
    }


    public List<ProjectDTO> getProjects() {
        return repository.findAll().stream().map(ProjectDTO::wrap).toList();
    }


    public void deleteProject(long id) {
        repository.deleteById(id);
    }


    public void deleteProjects() {
        repository.deleteAll();
    }


    public void editProject(long id, ProjectDTO projectDTO) {
        Project project = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setTechstack(projectDTO.getTechStack());
        project.setUrl(projectDTO.getUrl());
    }


    public void addProject(ProjectDTO projectDTO) {
        repository.save(Project.wrap(projectDTO));
    }
}
