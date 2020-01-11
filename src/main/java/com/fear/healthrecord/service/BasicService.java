package com.fear.healthrecord.service;

import com.fear.healthrecord.mapper.BasicUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BasicService {
    @Autowired
    BasicUsersMapper basicUsersMapper;
   public int insertuser(Map<String,Object> map){
        return basicUsersMapper.insertuser(map);
    }
    
    public List<Map<String,Object>> selectuser(Map<String,Object> map){
        return basicUsersMapper.selectuser(map);
    
    }
}
