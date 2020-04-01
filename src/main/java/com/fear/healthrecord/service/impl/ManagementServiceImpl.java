package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.ManagementMapper;
import com.fear.healthrecord.service.BasicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagementServiceImpl implements BasicService {
    @Autowired
    ManagementMapper managementMapper;
   public Map<String, Object> insertuser(Map<String,Object> map){
       Map<String, Object> re=new HashMap<>();
       try {
           if(managementMapper.insertuser(map)==1)
           {  re.put("code", "200");
               re.put("message", "success");
           }
           else
           {
               re.put("code", "100");
               re.put("message", "mession failed");
           }
           return re;

       }catch (Exception e){
           e.printStackTrace();
           re.put("code", "100");
           re.put("message", "mession failed");
           return re;
       }

    }

    @Override
    public Map<String,Object> insertuserinfo(Map<String, Object> map) {
        Map<String,Object> result =new HashMap<>();
       try {
           managementMapper.insertuserinfo(map);
           result.put("code","200");
           result.put("message","成功");
       }catch (Exception e){
           result.put("code","300");
           result.put("message","失败");
       }

       return result;

    }

    @Override
    public Map<String, Object> upadtauser(Map<String, Object> map) {
       int basic_id=Integer.parseInt(map.get("user_id").toString());
       map.put("basic_id",basic_id);
        Map<String,Object> result =new HashMap<>();
        try {
            managementMapper.upadtauser(map);
            result.put("code","200");
            result.put("message","成功");
        }catch (Exception e){
            result.put("code","300");
            result.put("message","失败");
        }

        return result;
    }

    @Override
    public Map<String, Object> upadtauserinfo(Map<String, Object> map) {
        Map<String,Object> result =new HashMap<>();
        try {
            if(managementMapper.upadtauserinfo(map)==1)
            {result.put("code","200");
            result.put("message","成功");}
            else {
                result.put("code","300");
                result.put("message","失败");
            }
        }catch (Exception e){
            result.put("code","300");
            result.put("message","失败");
        }

        return result;

    }

    @Override
    public Map<String, Object> selectuser(Map<String, Object> map) {

        int basic_id=Integer.parseInt(map.get("user_id").toString());
        map.put("basic_id",basic_id);
        Map<String,Object> list=managementMapper.selectuser(map);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("CODE","200");
        resultMap.put("MESSAGE","成功");
        resultMap.put("DATA",list);


        return resultMap;
    }

    @Override
    public Map<String, Object> selectuserlist(Map<String, Object> map) {
        int pageNum=Integer.parseInt(map.get("pageNum").toString());
        int pageSize=Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> list=managementMapper.selectuserlist(map);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(list);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("CODE","200");
        resultMap.put("MESSAGE","成功");
        resultMap.put("DATA",pageInfo);
        return resultMap;

    }

    @Override
    public Map<String, Object> selectuserinfo(Map<String, Object> map) {

        List<Map<String,Object>> list=managementMapper.selectuserinfo(map);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("CODE","200");
        resultMap.put("MESSAGE","成功");
        resultMap.put("DATA",list);
        return resultMap;

    }

    @Override
    public Map<String, Object> deleteuser(Map<String, Object> map) {
        int basic_id=Integer.parseInt(map.get("user_id").toString());
        map.put("basic_id",basic_id);
        Map<String,Object> result =new HashMap<>();
        try {
            managementMapper.deleteuser(map);
            managementMapper.deleteuserinfo(map);
            result.put("code","200");
            result.put("message","成功");
        }catch (Exception e){
            result.put("code","300");
            result.put("message","失败");
        }

        return result;

    }

    @Override
    public Map<String, Object> deleteuserinfo(Map<String, Object> map) {
        Map<String,Object> result =new HashMap<>();
        try {
            managementMapper.deleteuserinfo(map);
            result.put("code","200");
            result.put("message","成功");
        }catch (Exception e){
            result.put("code","300");
            result.put("message","失败");
        }

        return result;
    }
}
