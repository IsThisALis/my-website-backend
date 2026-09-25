package com.isthisalis.website.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isthisalis.website.dto.AboutDTO;
import com.isthisalis.website.service.AboutService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/about")
public class AboutController {
    
    private final AboutService aboutService;

    
    @GetMapping
    public AboutDTO getAbout() {
        return aboutService.get();
    }


    @PatchMapping
    public void editAbout(@Valid @RequestBody AboutDTO aboutDTO) {
        aboutService.edit(aboutDTO);
    }


    @DeleteMapping
    public void deleteAbout() {
        aboutService.delete();
    }
}
