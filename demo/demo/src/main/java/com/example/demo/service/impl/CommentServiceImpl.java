package com.example.demo.service.impl;

import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Comment;
import com.example.demo.entity.News;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Override
    public ResponseEntity<?> save(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        Optional<News> byId = newsRepository.findById(commentDto.getNewsId());
        if (byId.isPresent()){
            comment.setNews(byId.get());
            commentRepository.save(comment);
            return new ResponseEntity<>("Comment Saved", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> get() {
        List<Comment> all = commentRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
