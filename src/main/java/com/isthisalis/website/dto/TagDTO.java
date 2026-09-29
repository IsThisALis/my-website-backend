package com.isthisalis.website.dto;

import com.isthisalis.website.entity.Tag;

import lombok.Getter;
import lombok.Value;

@Value
public class TagDTO {
    
    @Getter String name;

    public static TagDTO wrap(Tag tag) {
        return new TagDTO(tag.getName());
    }
}
