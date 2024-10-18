package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String headline;
    private String news;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> category;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;
}
