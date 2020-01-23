package com.fear.healthrecord;

import com.fear.healthrecord.service.SystemUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
 class SystemUserTest {
    @Autowired
    SystemUserService service;
    @Test
    void register(){
        Map<String,Object> map=new HashMap<>();
        map.put("sys_user_name","fear");
        map.put("sys_user_password","123456");
        map.put("sys_rank",1);
        map.put("sys_status",1);
        service.registeruser(map);
    }
    @Test
    void login(){
        Map<String,Object> map=new HashMap<>();
        map.put("sys_user_name","fear");
        map.put("sys_user_password","123456");

        System.out.println( service.loginuser(map));
    }
}
