package com.liquid.service;

import com.liquid.domain.Comment;

import java.util.List;

public interface CommentService {
    public void createComment(Comment comment);
    public void deleteComment(Integer id);
    public List<Comment> findAllComment();
}
