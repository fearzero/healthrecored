package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.SystemUserMapper;
import com.fear.healthrecord.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Service
public class SystemUserServiceImpl implements SystemUserService {

@Autowired
    SystemUserMapper mapper;
    @Override
    public Map<String, Object> selectSysUserInfo(HttpServletRequest request) {
        Map<String, Object> map=new HashMap<>();

        Map<String, Object> respMap=new HashMap<>();
        try {

            String sign = request.getHeader("sign");

            map.put("sign",sign);
            Map<String, Object> dataMap=mapper.selectSysUserInfo(map);

            respMap.put("CODE","200");
            respMap.put("MESSAGE","成功");
            respMap.put("DATA",dataMap);
        }catch (Exception e){
            respMap.put("CODE","300");
            respMap.put("MESSAGE","失败");
        }

        return respMap;
    }

    @Override
    public Map<String, Object> updatePWD(HttpServletRequest request, Map<String, Object> map) {
        Map<String, Object> resultMap=new HashMap<>();
        Map<String, Object> requestMap1=new HashMap<>();
        Map<String, Object> requestMap2=new HashMap<>();
        String sign=request.getHeader("sign");
        requestMap1.put("sign",sign);
        requestMap2.put("sign",sign);
        requestMap2.put("sys_user_password",map.get("password2").toString());
        try{
            Map<String, Object>res=mapper.selectPWD(requestMap1);
            if(res.get("sys_user_password").toString().equals(map.get("password1").toString())){

            }
            else {
                resultMap.put("CODE","300");
                resultMap.put("MESSAGE","旧密码错误");
                return resultMap;
            }
        }catch (Exception e){
            resultMap.put("CODE","300");
            resultMap.put("MESSAGE","数据库访问失败");
            return resultMap;
        }
        try{
            mapper.updatePWD(requestMap2);

            resultMap.put("CODE","200");
            resultMap.put("MESSAGE","修改成功");
        }catch (Exception e){
            resultMap.put("CODE","300");
            resultMap.put("MESSAGE","数据库访问失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateSysUserInfo(HttpServletRequest request, Map<String, Object> map) {
        Map<String, Object> resultMap=new HashMap<>();

        String sign=request.getHeader("sign");
        map.put("sign",sign);
        try{
            if(mapper.updateSysUserInfo(map)==1)
            {  resultMap.put("CODE","200");
            resultMap.put("MESSAGE","修改成功");}
            else {
                resultMap.put("CODE","300");
                resultMap.put("MESSAGE","修改失败");
                return resultMap;
            }

        }catch (Exception e){
            resultMap.put("CODE","300");
            resultMap.put("MESSAGE","数据库访问失败");
        }
        return resultMap;
    }


}
