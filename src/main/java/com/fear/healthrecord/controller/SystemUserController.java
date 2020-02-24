package com.fear.healthrecord.controller;

import com.alibaba.fastjson.JSON;
import com.fear.healthrecord.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SystemUserController {
    @Autowired
    SystemUserService service;
    @RequestMapping("/register")
    public @ResponseBody Map<String, Object> register(@RequestBody String json){
        Map<String, Object> mp = JSON.parseObject(json);
        Map<String, Object> map=new HashMap<>();
        map.put("sys_user_name",mp.get("sys_user_name"));
        map.put("sys_user_password",mp.get("sys_user_password"));
        map.put("sys_rank",1);
        map.put("sys_status",1);
       int f= service.registeruser(map);
        Map<String, Object> re=new HashMap<>();
        if(f==1) {
            re.put("code", "200");
            re.put("message", "success");
        }
        else
        {
            re.put("code", "100");
            re.put("message", "mession failed");
        }
        return re;
    }
    @RequestMapping("/login")
   public @ResponseBody Map<String, Object>  login (@RequestBody  String json, HttpServletRequest request)
    {
        Map<String, Object> mp = JSON.parseObject(json);
        Map<String, Object> map=new HashMap<>();
        map.put("sys_user_name",mp.get("sys_user_name"));
        map.put("sys_user_password",mp.get("sys_user_password"));
        Map<String, Object> result=new HashMap<>();
        result=service.loginuser(map);
        HttpSession session = request.getSession();
        Map<String, Object> re=new HashMap<>();
        boolean f=result.get("sys_user_password").toString().equals(map.get("sys_user_password").toString());
        if(f) {
            re.put("code", "200");
            re.put("message", "success");
            session.setAttribute("user_id",result.get("sys_id").toString());
            session.setAttribute("user_name",result.get("sys_user_name").toString());
            System.out.println(session.getId());
        }
        else
        {
            re.put("code", "100");
            re.put("message", "mession failed");
        }
        return re;
    }
    @RequestMapping("/out")
    public @ResponseBody Map<String, Object>  out (HttpServletRequest request)
    {
        Map<String, Object> re=new HashMap<>();
        re.put("code", "200");
        re.put("message", "success");
        HttpSession session = request.getSession();
        session.removeAttribute("user_id");
        session.removeAttribute("user_name");

        System.out.println(session.getId());
        return re;
    }
}
