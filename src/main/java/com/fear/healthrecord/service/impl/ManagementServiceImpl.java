package com.fear.healthrecord.service.impl;

import com.fear.healthrecord.mapper.ManagementMapper;
import com.fear.healthrecord.mapper.UserIdCreateMapper;
import com.fear.healthrecord.service.BasicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ManagementServiceImpl implements BasicService {
    @Autowired
    ManagementMapper managementMapper;
    @Autowired
    UserIdCreateMapper userIdCreate;
   public Map<String, Object> insertuser(Map<String,Object> map){
       Map<String, Object> re=new HashMap<>();
       String uuid= UUID.randomUUID().toString().replace("-", "");
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       String create_time=df.format(new Date());// new Date()为获取当前系统时间
       Map<String, Object> creatuseridMap=new HashMap<>();
       Map<String, Object> updateuseridMap=new HashMap<>();

       creatuseridMap.put("uuid",uuid);
       creatuseridMap.put("create_time",create_time);

       userIdCreate.insertUserId(creatuseridMap);
       Map<String,Object> getUserIDMap=userIdCreate.selectUserId();
       String user_id=getUserIDMap.get("user_id").toString() ;
       map.put("user_id",user_id);
       updateuseridMap.put("uuid",uuid);
       updateuseridMap.put("user_id",user_id);
       userIdCreate.upadteUserId(updateuseridMap);
       try {
           if(managementMapper.insertuser(map)==1)
           {
               managementMapper.insertuserinfo(updateuseridMap);
               managementMapper.insertdisease(updateuseridMap);
               re.put("CODE", "200");
               re.put("MESSAGE", "success");
           }
           else
           {
               re.put("CODE", "100");
               re.put("MESSAGE", "mession failed");
           }
           return re;

       }catch (Exception e){
           e.printStackTrace();
           re.put("CODE", "100");
           re.put("MESSAGE", "mession failed");
           return re;
       }

    }

    @Override
    public Map<String,Object> insertuserinfo(Map<String, Object> map) {
        Map<String,Object> result =new HashMap<>();
       try {
           managementMapper.insertuserinfo(map);
           result.put("CODE","200");
           result.put("MESSAGE","成功");
       }catch (Exception e){
           result.put("CODE","300");
           result.put("MESSAGE","失败");
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
            result.put("CODE","200");
            result.put("MESSAGE","成功");
        }catch (Exception e){
            result.put("CODE","300");
            result.put("MESSAGE","失败");
        }

        return result;
    }

    @Override
    public Map<String, Object> upadtauserinfo(Map<String, Object> map) {
        Map<String,Object> result =new HashMap<>();
        try {
            if(managementMapper.upadtauserinfo(map)==1)
            {result.put("CODE","200");
            result.put("MESSAGE","成功");}
            else {
                result.put("CODE","300");
                result.put("MESSAGE","失败");
            }
        }catch (Exception e){
            result.put("CODE","300");
            result.put("MESSAGE","失败");
        }

        return result;

    }

    @Override
    public Map<String, Object> selectuser(Map<String, Object> map) {

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

        Map<String,Object> dataMap=managementMapper.selectuserinfo(map);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("CODE","200");
        resultMap.put("MESSAGE","成功");
        resultMap.put("DATA",dataMap);
        return resultMap;

    }

    @Override
    public Map<String, Object> deleteuser(Map<String, Object> map) {
        int basic_id=Integer.parseInt(map.get("user_id").toString());
        map.put("basic_id",basic_id);
        Map<String,Object> result =new HashMap<>();
        try {
            managementMapper.deleteuser(map);
            try {
                managementMapper.deleteuserinfo(map);
            }
           catch (Exception e){

           }
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

    @Override
    public Map<String, Object> insertdisease(Map<String, Object> map) {
        Map<String, Object> re=new HashMap<>();
        try {
            if(managementMapper.insertdisease(map)==1)
            {  re.put("CODE", "200");
                re.put("MESSAGE", "success");
            }
            else
            {
                re.put("CODE", "100");
                re.put("MESSAGE", "mession failed");
            }
            return re;

        }catch (Exception e){
            e.printStackTrace();
            re.put("CODE", "100");
            re.put("MESSAGE", "mession failed");
            return re;
        }

    }

    @Override
    public Map<String, Object> upadtedisease(Map<String, Object> map) {
        Map<String,Object> result =new HashMap<>();
        try {
            managementMapper.upadtedisease(map);
            result.put("CODE","200");
            result.put("MESSAGE","成功");
        }catch (Exception e){
            result.put("CODE","300");
            result.put("MESSAGE","失败");
        }

        return result;
    }


    @Override
    public Map<String, Object> deletedisease(Map<String, Object> map) {


        Map<String,Object> result =new HashMap<>();
        try {
            managementMapper.deletedisease(map);
            result.put("CODE","200");
            result.put("MESSAGE","成功");
        }catch (Exception e){
            result.put("CODE","300");
            result.put("MESSAGE","失败");
        }

        return result;
    }

    @Override
    public Map<String, Object> selectudisease(Map<String, Object> map) {
        Map<String,Object> dataMap=managementMapper.selectudisease(map);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("CODE","200");
        resultMap.put("MESSAGE","成功");
        resultMap.put("DATA",dataMap);
        return resultMap;
    }
}
