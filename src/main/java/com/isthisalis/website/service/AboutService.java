package com.isthisalis.website.service;

import org.springframework.stereotype.Service;

import com.isthisalis.website.dto.AboutDTO;
import com.isthisalis.website.repository.AboutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AboutService {
    
    private final AboutRepository repository;

    public AboutDTO getAbout() {
        return AboutDTO.wrap(repository.findAll().getLast());
    }
}
