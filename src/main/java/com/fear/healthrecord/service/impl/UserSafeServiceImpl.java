package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.SystemUserMapper;
import com.fear.healthrecord.mapper.UserSafeMapper;
import com.fear.healthrecord.myunitls.JWTUtils;
import com.fear.healthrecord.myunitls.MD5Utils;
import com.fear.healthrecord.service.UserSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserSafeServiceImpl implements UserSafeService {
    @Autowired
    UserSafeMapper mapper;
    @Autowired
    SystemUserMapper systemUserMapper;
    @Override
    public Map<String, Object> registeruser(Map<String, Object> mp) {
        Map<String, Object> requestMap1=new HashMap<>();
        Map<String, Object> resultMap=new HashMap<>();
        requestMap1.put("sys_user_name",mp.get("user_name"));
        requestMap1.put("sys_user_password",mp.get("user_password"));
        requestMap1.put("sys_rank",3);
        requestMap1.put("sys_status",1);
        String sign=mp.get("user_name").toString()+mp.get("user_password").toString();
        sign= MD5Utils.getMD5(sign);
        requestMap1.put("sign",sign);
        Map<String, Object> requestMap2=new HashMap<>();
        Map<String, Object> requestMap3=new HashMap<>();
        requestMap2.put("sys_user_name",mp.get("user_name"));
        try {
            mapper.registeruser(requestMap1);
            Map<String, Object> res=mapper.selectSys_id(requestMap2);
            requestMap3.put("sys_id",res.get("sys_id"));
            mapper.insertSysUserInfo(requestMap3);
            resultMap.put("CODE","200");
            resultMap.put("MESSAGE","注册成功");
        }catch (Exception e){
            resultMap.put("CODE","300");
            resultMap.put("MESSAGE","注册失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> loginuser(Map<String, Object> mp, HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> map=new HashMap<>();
        map.put("sys_user_name",mp.get("user_name"));
        map.put("sys_user_password",mp.get("user_password"));
        Map<String, Object> result=new HashMap<>();
        result=mapper.loginuser(map);

        Map<String, Object> re=new HashMap<>();
        boolean f=result.get("sys_user_password").toString().equals(map.get("sys_user_password").toString());
        if(f) {
            String jwt = JWTUtils.getToken(mp.get("user_name").toString());
            String sign=result.get("sign").toString();
            response.setHeader("Authorization",jwt);
            re.put("CODE", "200");
            re.put("MESSAGE", "success");
            re.put("TOKEN",jwt);
            re.put("SIGN",sign);
            String ip_address=request.getRemoteAddr();
            String host_name=request.getRemoteHost();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String login_time=df.format(new Date());// new Date()为获取当前系统时间
            Map<String, Object> logsMap=new HashMap<>();
            logsMap.put("user_name",mp.get("user_name"));
            logsMap.put("sign",sign);
            logsMap.put("ip_address",ip_address);
            logsMap.put("host_name",host_name);
            logsMap.put("login_time",login_time);
          systemUserMapper.insertLogs(logsMap);
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
