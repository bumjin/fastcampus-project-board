package com.fastcampus.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * /articles
 * /articles/{article-id}
 * /articles/search
 * /ariticles/search-hashtag
 */
@RequestMapping("/articles")
@Controller
public class ArticleController {
    @GetMapping
    public  String articles(ModelMap map) {
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public  String article(@PathVariable(name="articleId") Long articleId, ModelMap map) {
        map.addAttribute("article", "article");//TODO: 구현할 때  실제 데이타를
        map.addAttribute("articleComments", List.of());
        return "articles/detail";
    }
}
