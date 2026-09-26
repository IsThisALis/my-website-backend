package com.isthisalis.website.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.isthisalis.website.dto.AboutDTO;
import com.isthisalis.website.entity.About;
import com.isthisalis.website.repository.AboutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AboutService {
    
    private final AboutRepository repository;


    public AboutDTO getAbout() {
        return AboutDTO.wrap(repository.findAll().getLast());
    }

    public void createAbout(AboutDTO aboutDTO) {
        repository.save(About.wrap(aboutDTO));
    }

    public void editAbout(AboutDTO aboutDTO) {
        About about = repository.findById(1L)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404))
        );

        about.setTitle(aboutDTO.getTitle());
        about.setContent(aboutDTO.getContent());
        about.setTechstack(aboutDTO.getTechStack());
    }


    public void deleteAbout() {
        repository.deleteById(1L);
    }
}
