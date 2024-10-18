package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewsDto {
    private Long id;
    private String headline;
    private String news;
    private List<CategoryDto> category;
    private List<CommentDto> comments;
}
