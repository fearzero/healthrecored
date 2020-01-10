package com.fear.healthrecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class TestController {
    @RequestMapping("/doPostTwo")
    public @ResponseBody String doPostTwo(String name, int age){
        return name+"已经"+age+"岁了";
    }
}
