package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserSafeMapper {
    int registeruser(Map<String,Object> map);
    int insertSysUserInfo(Map<String,Object> map);
    Map<String,Object> selectSys_id(Map<String,Object> map);
    Map<String,Object> loginuser(Map<String,Object> map);
}
