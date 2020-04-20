package com.fear.healthrecord.controller;

import com.alibaba.fastjson.JSON;
import com.fear.healthrecord.service.UserSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(value = "/system")
public class UserSafeController {
    @Autowired
    UserSafeService service;
    @CrossOrigin
    @RequestMapping("/register")
    public @ResponseBody Map<String, Object> register(@RequestBody String json){
        Map<String, Object> mp = JSON.parseObject(json);
        return service.registeruser(mp);
    }
    @CrossOrigin
    @RequestMapping("/login")
   public @ResponseBody Map<String, Object>  login (@RequestBody  String json, HttpServletResponse response)
    {
        Map<String, Object> mp = JSON.parseObject(json);

        return service.loginuser(mp,response);
    }
    @RequestMapping("/out")
    public @ResponseBody Map<String, Object>  outline (HttpServletRequest request)
    {
      return service.outline(request);
    }
}
