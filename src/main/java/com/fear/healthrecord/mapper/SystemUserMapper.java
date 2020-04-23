package com.fear.healthrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Mapper
@Repository
public interface SystemUserMapper {
    Map<String,Object> selectSysUserInfo(Map<String,Object> map);
    Map<String,Object> selectPWD(Map<String,Object> map);
    int updatePWD(Map<String,Object> map);
    int updateSysUserInfo(Map<String,Object> map);
}
