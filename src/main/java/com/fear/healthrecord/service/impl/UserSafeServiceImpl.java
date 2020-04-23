package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.UserSafeMapper;
import com.fear.healthrecord.myunitls.JWTUtils;
import com.fear.healthrecord.service.UserSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserSafeServiceImpl implements UserSafeService {
    @Autowired
    UserSafeMapper mapper;
    @Override
    public Map<String, Object> registeruser(Map<String, Object> mp) {
        Map<String, Object> map=new HashMap<>();
        map.put("sys_user_name",mp.get("user_name"));
        map.put("sys_user_password",mp.get("user_password"));
        map.put("sys_rank",3);
        map.put("sys_status",1);
        int f= mapper.registeruser(map);
        Map<String, Object> re=new HashMap<>();
        if(f==1) {
            re.put("CODE", "200");
            re.put("MESSAGE", "success");
        }
        else
        {
            re.put("CODE", "100");
            re.put("MESSAGE", "mession failed");
        }
        return re;
    }

    @Override
    public Map<String, Object> loginuser(Map<String, Object> mp, HttpServletResponse response) {
        Map<String, Object> map=new HashMap<>();
        map.put("sys_user_name",mp.get("user_name"));
        map.put("sys_user_password",mp.get("user_password"));
        Map<String, Object> result=new HashMap<>();
        result=mapper.loginuser(map);

        Map<String, Object> re=new HashMap<>();
        boolean f=result.get("sys_user_password").toString().equals(map.get("sys_user_password").toString());
        if(f) {
            String jwt = JWTUtils.getToken(mp.get("user_name").toString());
            response.setHeader("Authorization",jwt);
            re.put("CODE", "200");
            re.put("MESSAGE", "success");
            re.put("TOKEN",jwt);
        }
        else
        {
            re.put("CODE", "300");
            re.put("MESSAGE", "mession failed");
        }
        return re;
    }

    @Override
    public Map<String, Object> outline(HttpServletRequest request) {
        Map<String, Object> re=new HashMap<>();
        re.put("CODE", "200");
        re.put("MESSAGE", "success");
        HttpSession session = request.getSession();
        session.removeAttribute("user_id");
        session.removeAttribute("user_name");

        System.out.println(session.getId());
        return re;
    }
}
