package com.fear.healthrecord.service;

import com.fear.healthrecord.mapper.BasicUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


public class BasicServiceImpl implements BasicService {
    @Autowired
    BasicUsersMapper basicUsersMapper;
   public int insertuser(Map<String,Object> map){
        return basicUsersMapper.insertuser(map);
    }
}
