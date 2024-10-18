package com.example.demo.service;

import com.example.demo.dto.NewsDto;
import org.springframework.http.ResponseEntity;

public interface NewsService {

    ResponseEntity<?> save(NewsDto newsDto);
    ResponseEntity<?> getAll();
    ResponseEntity<?> getByCategory(Long categoryId);
}
