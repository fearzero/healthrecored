package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.BasicUsersMapper;
import com.fear.healthrecord.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class BasicServiceImpl implements BasicService {
    @Autowired
    BasicUsersMapper basicUsersMapper;
   public int insertuser(Map<String,Object> map){
        return basicUsersMapper.insertuser(map);
    }

    @Override
    public int insertuserinfo(Map<String, Object> map) {
        return basicUsersMapper.insertuserinfo(map);
    }

    @Override
    public int upadtauser(Map<String, Object> map) {
        return basicUsersMapper.upadtauser(map);
    }

    @Override
    public int upadtauserinfo(Map<String, Object> map) {
        return basicUsersMapper.upadtauserinfo(map);
    }

    @Override
    public List<Map<String, Object>> selectuser(Map<String, Object> map) {
        return  basicUsersMapper.selectuser(map);
    }

    @Override
    public List<Map<String, Object>> selectuserlist(Map<String, Object> map) {
        return basicUsersMapper.selectuserlist(map);
    }

    @Override
    public List<Map<String, Object>> selectuserinfo(Map<String, Object> map) {
        return basicUsersMapper.selectuserinfo(map);
    }

    @Override
    public int deleteuser(Map<String, Object> map) {
        return basicUsersMapper.deleteuser(map);
    }
}
