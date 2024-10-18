package com.example.demo.service.impl;

import com.example.demo.dto.NewsDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.News;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<?> save(NewsDto newsDto) {
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        List<Category> categories = new ArrayList<>();
        newsDto.getCategory().forEach(categoryDto -> {
            Optional<Category> byId = categoryRepository.findById(categoryDto.getId());
            if(byId.isPresent()){
                categories.add(byId.get());
            }else {
                throw new RuntimeException("Not found");
            }

        });
        news.setCategory(categories);
        newsRepository.save(news);
        return new ResponseEntity<>("News Saved", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(newsRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByCategory(Long categoryId) {
        Optional<Category> byId = categoryRepository.findById(categoryId);
        if(byId.isPresent()){
           return new ResponseEntity<>(newsRepository.findByCategory(byId.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }
}
