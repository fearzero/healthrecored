package com.fear.healthrecord.controller;

import com.alibaba.fastjson.JSON;
import com.fear.healthrecord.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {

     @Autowired
    BasicService basicService;

    @CrossOrigin
    @RequestMapping("/insertuser")

    public @ResponseBody Object insertuser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
       return basicService.insertuser(map);
    }

    @RequestMapping("/insertuserinfo")
    @CrossOrigin
    public @ResponseBody Object insertuserinfo(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.insertuserinfo(map);
    }
    @CrossOrigin
    @RequestMapping("/upadtauser")
    public @ResponseBody Object upadtauser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.upadtauser(map);
    }
    @CrossOrigin
    @RequestMapping("/deleteuser")
    public @ResponseBody int deleteuser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.deleteuser(map);
    }
    @CrossOrigin
    @RequestMapping("/selectuser")
    public @ResponseBody Map<String,Object> selectuser(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.selectuser(map);
    }
    @CrossOrigin
    @RequestMapping("/selectuserlist")
    public @ResponseBody Map<String,Object> selectuserlist(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.selectuserlist(map);
    }
    @CrossOrigin
    @RequestMapping("/selectuserinfo")
    public @ResponseBody Map<String,Object> selectuserinfo(@RequestBody String json){
        Map<String, Object> map = JSON.parseObject(json);
        return basicService.selectuserinfo(map);
    }
}
