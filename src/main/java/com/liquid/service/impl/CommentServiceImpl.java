package com.liquid.service.impl;

import com.liquid.domain.Comment;
import com.liquid.mapper.CommentMapper;
import com.liquid.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void createComment(Comment comment) {
        commentMapper.createComment(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentMapper.deleteComment(id);
    }

    @Override
    public List<Comment> findAllComment() {
        return commentMapper.findAllComment();
    }
}
