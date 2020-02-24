package com.fear.healthrecord.controller;

import com.alibaba.fastjson.JSON;
import com.fear.healthrecord.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {
    @RequestMapping("/test")
    public @ResponseBody String doPostTwo(String name, int age){
        return name+"已经"+age+"岁了";
    }
@Autowired
    BasicService basicService;
    @RequestMapping("/insertuser")
    public @ResponseBody int insertuser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.insertuser(map);
    }
    @RequestMapping("/insertuserinfo")
    public @ResponseBody int insertuserinfo(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.insertuserinfo(map);
    }
    @RequestMapping("/upadtauser")
    public @ResponseBody int upadtauser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.upadtauser(map);
    }
    @RequestMapping("/deleteuser")
    public @ResponseBody int deleteuser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.deleteuser(map);
    }
    @RequestMapping("/selectuser")
    public @ResponseBody List<Map<String,Object>> selectuser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.selectuser(map);
    } @RequestMapping("/selectuserlist")
    public @ResponseBody List<Map<String,Object>> selectuserlist(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.selectuserlist(map);
    } @RequestMapping("/selectuserinfo")
    public @ResponseBody List<Map<String,Object>> selectuserinfo(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.selectuserinfo(map);
    }
}
