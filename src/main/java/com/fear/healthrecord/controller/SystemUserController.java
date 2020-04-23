package com.fear.healthrecord.controller;

import com.alibaba.fastjson.JSON;
import com.fear.healthrecord.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/systemUser")
@CrossOrigin
public class SystemUserController {
    @Autowired
    SystemUserService service;
    @RequestMapping("/selectSysUserInfo")
    public @ResponseBody
    Map<String, Object> selectSysUserInfo (HttpServletRequest request)

    {
        return service.selectSysUserInfo(request);
    }
    @RequestMapping("/updatePWD")
    public @ResponseBody
    Map<String,Object> updatePWD(HttpServletRequest request ,@RequestBody String json)
    {
        Map<String, Object> map = JSON.parseObject(json);
        return service.updatePWD(request,map);
    }
    @RequestMapping("/updateSysUserInfo")
    public @ResponseBody
    Map<String,Object> updateSysUserInfo(HttpServletRequest request ,@RequestBody String json)
    {
        Map<String, Object> map = JSON.parseObject(json);
        return service.updateSysUserInfo(request,map);
    }
}
