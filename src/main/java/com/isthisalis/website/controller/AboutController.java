package com.isthisalis.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isthisalis.website.dto.AboutDTO;
import com.isthisalis.website.service.AboutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/about")
public class AboutController {
    
    private final AboutService service;

    @GetMapping
    public AboutDTO getAbout() {
        return service.getAbout();
    }
}
