package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ManagementMapper {
    int insertuser(Map<String,Object> map);
    int insertuserinfo(Map<String,Object> map);
    int upadtauser(Map<String,Object> map);
    int upadtauserinfo(Map<String,Object> map);
   Map<String,Object> selectuser(Map<String,Object> map);
    List<Map<String,Object>> selectuserlist(Map<String,Object> map);
    Map<String,Object> selectuserinfo(Map<String,Object> map);
    int deleteuser(Map<String,Object> map);
    int deleteuserinfo(Map<String,Object> map);
    int insertdisease(Map<String,Object> map);
    int upadtedisease(Map<String,Object> map);
    int deletedisease(Map<String,Object> map);
    Map<String,Object> selectudisease(Map<String,Object> map);

}
