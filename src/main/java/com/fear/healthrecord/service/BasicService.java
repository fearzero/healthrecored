package com.fear.healthrecord.service;



import java.util.List;
import java.util.Map;


public interface BasicService {
     int insertuser(Map<String,Object> map);
    int insertuserinfo(Map<String,Object> map);
    int upadtauser(Map<String,Object> map);
    int upadtauserinfo(Map<String,Object> map);
     List<Map<String,Object>> selectuser(Map<String,Object> map);
    List<Map<String,Object>> selectuserlist(Map<String,Object> map);
    List<Map<String,Object>> selectuserinfo(Map<String,Object> map);
    int deleteuser(Map<String,Object> map);
}
