package com.liquid.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Api;
import com.liquid.common.api.ApiResult;
import com.liquid.domain.Article;
import com.liquid.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/findAllArticle",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<List<Article>> findAll(HttpServletRequest request) throws JsonProcessingException {
        List<Article> articleList = articleService.findAll();
        if(ObjectUtils.isEmpty(articleList)){
            return ApiResult.failed("查询失败");
        }
        return ApiResult.success(articleList,"查询成功");
    }

    @RequestMapping(value="/insertArticle",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult insertArticle(Article article){
        article.setArticleUpdateTime(new Date());
        article.setArticleCreateTime(new Date());
        articleService.insertArticle(article);
        return ApiResult.success("插入成功");
    }

    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult updateArticle(Article article){
        System.out.println(article);
        article.setArticleUpdateTime(new Date());
        articleService.updateArticle(article);
        return ApiResult.success("更新成功");
    }

    @RequestMapping(value = "/deleteArticle",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult deleteArticle(Integer id){
        articleService.deleteArticle(id);
        return ApiResult.success("更新成功");
    }

    @RequestMapping(value = "/findArticleById",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<List<Article>> findArticleById(Integer id) throws JsonProcessingException {
        List<Article> articleList = articleService.findArticleById(id);
        if(ObjectUtils.isEmpty(articleList)){
            return ApiResult.failed("查询失败");
        }
        return ApiResult.success(articleList,"查询成功");
    }
}
