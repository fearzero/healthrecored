package com.fear.healthrecord.controller;

import com.fear.healthrecord.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/systemUser")
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
}
