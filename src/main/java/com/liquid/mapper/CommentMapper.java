package com.liquid.mapper;

import com.liquid.domain.Comment;

import java.util.List;

public interface CommentMapper {
    public void createComment(Comment comment);
    public void deleteComment(Integer id);
    public List<Comment> findAllComment();
}
