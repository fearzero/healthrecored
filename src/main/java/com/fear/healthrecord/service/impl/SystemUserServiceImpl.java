package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.SystemUserMapper;
import com.fear.healthrecord.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    SystemUserMapper mapper;
    @Override
    public int registeruser(Map<String, Object> map) {
        return mapper.registeruser(map);
    }

    @Override
    public Map<String, Object> loginuser(Map<String, Object> map) {
        return mapper.loginuser(map);
    }
}
