package com.example.demo.service.impl;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.News;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Override
    public ResponseEntity<?> save(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryRepository.save(category);
        return new ResponseEntity<>("Category Saved", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> get() {
        List<Category> all = categoryRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        List<News> byCategory = new ArrayList<>();
        if(byId.isPresent()){
            byCategory = newsRepository.findByCategory(byId.get());
        }
        return new ResponseEntity<>(byCategory, HttpStatus.OK);
    }

}
