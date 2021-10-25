package com.liquid.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.liquid.common.api.ApiResult;
import com.liquid.domain.Admin;
import com.liquid.util.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final String USERNAME="nymnym";
    private final String PASSWORD="nymnym";

    @RequestMapping(value = "/checkAdmin",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Admin> checkAdmin(Admin admin) throws JsonProcessingException {
        if(USERNAME.equals(admin.getUsername())&&PASSWORD.equals(admin.getPassword())){
            admin.setToken(JwtUtil.createToken());
            return ApiResult.success(admin,"成功");
        }
        return ApiResult.failed("用户名或密码错误");
    }

    @RequestMapping(value = "/checkToken",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Boolean> checkToken(String token){
        System.out.println("token:"+token);
        return ApiResult.success(JwtUtil.checkToken(token),"");
    }
}
