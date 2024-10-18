package com.example.demo.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long newsId;
    private String comment;
}
