package com.liquid.controller;

import com.liquid.common.api.ApiResult;
import com.liquid.domain.Comment;
import com.liquid.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/createComment")
    @ResponseBody
    public ApiResult createComment(Comment comment, HttpServletRequest request){
        String host = request.getRemoteAddr();
        String agent = request.getHeader("user-agent");
        if(comment.getName().equals("")){
            comment.setName(host);
        }
        comment.setAgent(agent);
        comment.setHost(host);
        comment.setTime(new Date());
        System.out.println(comment);
        commentService.createComment(comment);
        return ApiResult.success("success");
    }
    @RequestMapping("/deleteComment")
    @ResponseBody
    public ApiResult createComment(Integer id){
        commentService.deleteComment(id);
        return ApiResult.success("success");
    }
    @RequestMapping("/findAllComment")
    @ResponseBody
    public ApiResult<List<Comment>> findAllComment(){
        List<Comment> commentList = commentService.findAllComment();
        return ApiResult.success(commentList,"查询成功");
    }
}
