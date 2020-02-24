package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.ManagementMapper;
import com.fear.healthrecord.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class ManagementServiceImpl implements BasicService {
    @Autowired
    ManagementMapper managementMapper;
   public int insertuser(Map<String,Object> map){
        return managementMapper.insertuser(map);
    }

    @Override
    public int insertuserinfo(Map<String, Object> map) {
        return managementMapper.insertuserinfo(map);
    }

    @Override
    public int upadtauser(Map<String, Object> map) {
        return managementMapper.upadtauser(map);
    }

    @Override
    public int upadtauserinfo(Map<String, Object> map) {
        return managementMapper.upadtauserinfo(map);
    }

    @Override
    public List<Map<String, Object>> selectuser(Map<String, Object> map) {
        return  managementMapper.selectuser(map);
    }

    @Override
    public List<Map<String, Object>> selectuserlist(Map<String, Object> map) {
        return managementMapper.selectuserlist(map);
    }

    @Override
    public List<Map<String, Object>> selectuserinfo(Map<String, Object> map) {
        return managementMapper.selectuserinfo(map);
    }

    @Override
    public int deleteuser(Map<String, Object> map) {
        return managementMapper.deleteuser(map);
    }
}
