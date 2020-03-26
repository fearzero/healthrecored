package com.fear.healthrecord.service;



import java.util.Map;


public interface BasicService {
    Map<String,Object> insertuser(Map<String,Object> map);
    int insertuserinfo(Map<String,Object> map);
    int upadtauser(Map<String,Object> map);
    int upadtauserinfo(Map<String,Object> map);
     Map<String,Object> selectuser(Map<String,Object> map);
    Map<String,Object> selectuserlist(Map<String,Object> map);
    Map<String,Object> selectuserinfo(Map<String,Object> map);
    int deleteuser(Map<String,Object> map);
}
