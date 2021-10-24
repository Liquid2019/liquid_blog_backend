package com.liquid.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.liquid.common.api.ApiResult;
import com.liquid.domain.Article;
import com.liquid.domain.Friend;
import com.liquid.service.ArticleService;
import com.liquid.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/findAllFriend",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<List<Friend>> findAllFriend() throws JsonProcessingException {
        List<Friend> friendList = friendService.findAllFriend();
        if(ObjectUtils.isEmpty(friendList)){
            return ApiResult.failed("查询失败");
        }
        return ApiResult.success(friendList,"查询成功");
    }

    @RequestMapping(value = "/insertFriend",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult insertFriend(Friend friend) throws JsonProcessingException {
        friendService.insertFriend(friend);
        return ApiResult.success("创建成功");
    }

    @RequestMapping(value = "/deleteFriend",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult deleteFriend(Integer id) throws JsonProcessingException {
        friendService.deleteFriend(id);
        return ApiResult.success("删除成功");
    }
}
