package com.liquid.mapper;

import com.liquid.domain.Article;

import java.util.List;

public interface ArticleMapper {
    public List<Article> findAll();
    public void insertArticle(Article article);

    public void updateArticle(Article article);

    public void deleteArticle(Integer id);

    public List<Article> findArticleById(Integer id);

}
