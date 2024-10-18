package com.example.demo.service;

import com.example.demo.dto.CommentDto;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    ResponseEntity<?> save(CommentDto commentDto);
    ResponseEntity<?> get();
}
