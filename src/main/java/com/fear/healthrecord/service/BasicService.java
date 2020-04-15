package com.fear.healthrecord.service;



import java.util.Map;


public interface BasicService {
    Map<String,Object> insertuser(Map<String,Object> map);
    Map<String,Object> insertuserinfo(Map<String,Object> map);
    Map<String,Object> upadtauser(Map<String,Object> map);
    Map<String,Object> upadtauserinfo(Map<String,Object> map);
     Map<String,Object> selectuser(Map<String,Object> map);
    Map<String,Object> selectuserlist(Map<String,Object> map);
    Map<String,Object> selectuserinfo(Map<String,Object> map);
    Map<String,Object> deleteuser(Map<String,Object> map);
    Map<String,Object> deleteuserinfo(Map<String,Object> map);
    Map<String,Object> insertdisease(Map<String,Object> map);
    Map<String,Object> upadtedisease(Map<String,Object> map);
    Map<String,Object> deletedisease(Map<String,Object> map);
    Map<String,Object> selectudisease(Map<String,Object> map);
}
