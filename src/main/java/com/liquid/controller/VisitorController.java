package com.liquid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liquid.common.api.ApiResult;
import com.liquid.domain.Article;
import com.liquid.domain.Friend;
import com.liquid.domain.Visitor;
import com.liquid.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    VisitorService visitorService;

    @RequestMapping(value = "/findAllVisitor",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<List<Visitor>> findAll(HttpServletRequest request) throws JsonProcessingException {
        List<Visitor> visitorList = visitorService.findAllVisitor();
        if(ObjectUtils.isEmpty(visitorList)){
            return ApiResult.failed("查询失败");
        }
        return ApiResult.success(visitorList,"查询成功");
    }

    @RequestMapping(value = "/insertVisitor",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult insertFriend(HttpServletRequest request) throws JsonProcessingException {
        String host = request.getRemoteAddr();
        String agent = request.getHeader("user-agent");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Visitor visitor = new Visitor();
        visitor.setHost(host);
        visitor.setAgent(agent);
        visitor.setTime(new Date());
        visitorService.createVisitor(visitor);
        return ApiResult.success();
    }


    @RequestMapping(value = "/deleteAllVisitor",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult deleteAll() throws JsonProcessingException {
        visitorService.deleteAllVisitor();
        return ApiResult.success("删除成功");
    }
}

