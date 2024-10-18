package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<?> save(CategoryDto categoryDto);
    ResponseEntity<?> get();
    ResponseEntity<?> getById(Long id);
}
