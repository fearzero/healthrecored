package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.SystemUserMapper;
import com.fear.healthrecord.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Service
public class SystemUserServiceImpl implements SystemUserService {

@Autowired
    SystemUserMapper mapper;
    @Override
    public Map<String, Object> selectSysUserInfo(HttpServletRequest request) {
        Map<String, Object> map=new HashMap<>();
        HttpSession session = request.getSession();
        Map<String, Object> respMap=new HashMap<>();
        try {

            String sys_user_name = session.getAttribute("user_name").toString();
            map.put("sys_user_name",sys_user_name);
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
    public Map<String, Object> whoOnline(HttpServletRequest request) {
        return null;
    }
}
