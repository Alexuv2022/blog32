package com.example.blog32.controller;

import com.example.blog32.entity.ArticleEntity;
import com.example.blog32.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepo articleRepo;

    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute ArticleEntity article){
        articleRepo.save(article);
        return "OK";
    }

    @GetMapping("/getArticles")
    public ResponseEntity getArticles() {
        ArrayList<ArticleEntity> articles = (ArrayList<ArticleEntity>) articleRepo.findAll();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
