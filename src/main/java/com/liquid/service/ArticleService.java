package com.liquid.service;

import com.liquid.domain.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> findAll();
    public void insertArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(Integer id);

    List<Article> findArticleById(Integer id);
}
